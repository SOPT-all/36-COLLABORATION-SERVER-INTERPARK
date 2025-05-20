package com.interpark.domain.seat.detail.service;

import com.interpark.domain.seat.detail.dto.SeatRowDto;
import com.interpark.domain.seat.detail.entity.SeatDetail;
import com.interpark.domain.seat.detail.repository.SeatDetailRepository;
import com.interpark.domain.seat.entity.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatDetailService {

    private final SeatDetailRepository seatDetailRepository;

    // 좌석 상태 조회
    public List<SeatRowDto> getSeatStatus(){
        List<SeatDetail> all = seatDetailRepository.findAllWithSeat(); // 좌석과 seat fetch join 포함

        // rowAlphabet + grade 기준으로 그룹핑
        Map<String, List<SeatDetail>> grouped = all.stream()
                .collect(Collectors.groupingBy(seatDetail ->
                        seatDetail.getRowAlphabet() + "_" + seatDetail.getSeat().getSeatGrade()));

        List<SeatRowDto> result = new ArrayList<>();

        for (List<SeatDetail> group : grouped.values()) {
            group.sort(Comparator.comparingInt(SeatDetail::getSeatNumber)); // 좌석 번호순 정렬

            Seat seat = group.get(0).getSeat(); // 동일한 Seat 사용
            char row = group.get(0).getRowAlphabet();

            List<Boolean> availability = group.stream()
                    .map(sd -> !sd.isSold()) // 매진되지 않은 것이 true
                    .collect(Collectors.toList());

            result.add(new SeatRowDto(seat.getSeatGrade(), seat.getSeatPrice(), row, availability));
        }

        return result;
    }
}

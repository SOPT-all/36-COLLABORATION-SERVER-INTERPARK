package com.interpark.domain.seat.detail.service;

import com.interpark.domain.seat.detail.dto.*;
import com.interpark.domain.seat.detail.entity.SeatDetail;
import com.interpark.domain.seat.detail.repository.SeatDetailRepository;
import com.interpark.domain.seat.entity.Seat;
import com.interpark.global.error.code.ErrorCode;
import com.interpark.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeatDetailService {

    private final SeatDetailRepository seatDetailRepository;

    // 좌석 상태 조회
    public List<SeatRowDto> getSeatStatus(){
        List<SeatDetail> all = seatDetailRepository.findAllWithSeat(); // 좌석과 seat fetch join 포함

        // rowAlphabet + grade 기준으로 그룹핑
        Map<Character, List<SeatDetail>> grouped = all.stream()
                .collect(Collectors.groupingBy(SeatDetail::getRowAlphabet));

        List<SeatRowDto> result = new ArrayList<>();

        for (List<SeatDetail> group : grouped.values()) {
            group.sort(Comparator.comparingInt(SeatDetail::getSeatNumber)); // 좌석 번호순 정렬

            Seat seat = group.get(0).getSeat(); // 동일한 Seat 사용
            char row = group.get(0).getRowAlphabet();

            List<Boolean> availability = group.stream()
                    .map(sd -> sd.isSold()) // 매진되지 않은 것이 false
                    .collect(Collectors.toList());

            result.add(new SeatRowDto(seat.getSeatGrade(), seat.getSeatPrice(), row, availability));
        }

        return result;
    }

    // 좌석 선택
    @Transactional
    public SeatPatchRequest updateSeats(SeatPatchRequest seatPatchRequest){

        return new SeatPatchRequest(seatPatchRequest.seats().stream()
                .map(sd -> {
                    SeatDetail seatDetail = seatDetailRepository.findByRowAlphabetAndSeatNumber(sd.row().charAt(0), sd.number())
                            .orElseThrow(() -> new BusinessException(ErrorCode.DATA_NOT_FOUND));

                    if (seatDetail.isSold()) {
                        throw new BusinessException(ErrorCode.BAD_REQUEST_DATA);
                    }

                    seatDetail.setSold(true); // 상태 변경

                    return SeatPatchDto.of(seatDetail.getSeat().getSeatGrade(), seatDetail.getRowAlphabet(), seatDetail.getSeatNumber());
                })
                .toList());
    }

    public DateResponse getPerformance(){
        List<SeatDetail> rSeatCount = seatDetailRepository.findAvailableSeatsByGrade("R");
        List<SeatDetail> sSeatCount = seatDetailRepository.findAvailableSeatsByGrade("S");

        List<SeatGradeDto> seatGradeDtos = List.of(
                new SeatGradeDto("R", 66000, rSeatCount.size()),
                new SeatGradeDto("S", 44000, sSeatCount.size()));

        PerformanceDto performanceDto = new PerformanceDto(
                "연극 <프라이드>: 연극 열전10_다섯 번째 작품",
                "예스24아트원 2관",
                "/images/poster001.png",
                "연극",
                "170분",
                16, LocalTime.of(19, 30), "이형훈, 김이준, 홍금비, 박성현"
        );

        return new DateResponse(performanceDto, seatGradeDtos);
    }
}

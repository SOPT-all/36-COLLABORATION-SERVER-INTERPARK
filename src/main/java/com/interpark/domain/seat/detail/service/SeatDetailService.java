package com.interpark.domain.seat.detail.service;

import com.interpark.domain.seat.detail.dto.DateResponse;
import com.interpark.domain.seat.detail.dto.PerformanceDto;
import com.interpark.domain.seat.detail.dto.SeatGradeDto;
import com.interpark.domain.seat.detail.repository.SeatDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatDetailService {
    private final SeatDetailRepository seatDetailRepository;

    public DateResponse getPerformance(){
        int rSeatCount = seatDetailRepository.countByIsSoldAndSeatSeatGrade("R");
        int sSeatCount = seatDetailRepository.countByIsSoldAndSeatSeatGrade("S");

        List<SeatGradeDto> seatGradeDtos = List.of(
                new SeatGradeDto("R", 66000, rSeatCount),
                new SeatGradeDto("S", 44000, sSeatCount));

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

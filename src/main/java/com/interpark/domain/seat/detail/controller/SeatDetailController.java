package com.interpark.domain.seat.detail.controller;

import com.interpark.domain.seat.detail.dto.SeatResponse;
import com.interpark.domain.seat.detail.dto.SeatRowDto;
import com.interpark.domain.seat.detail.service.SeatDetailService;
import com.interpark.global.dto.SuccessResponse;
import com.interpark.global.error.code.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SeatDetailController {

    private final SeatDetailService seatDetailService;

    // 좌석 상태 조회
    @GetMapping("/tickets/seat")
    public ResponseEntity<SuccessResponse<SeatResponse>> getSeatStatus(){
        List<SeatRowDto> seatStatus = seatDetailService.getSeatStatus();

        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, new SeatResponse(seatStatus)));
    }
}

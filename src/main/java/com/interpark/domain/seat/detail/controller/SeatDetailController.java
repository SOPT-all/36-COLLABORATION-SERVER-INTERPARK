package com.interpark.domain.seat.detail.controller;

import com.interpark.domain.seat.detail.dto.DateResponse;
import com.interpark.domain.seat.detail.service.SeatDetailService;
import com.interpark.global.dto.SuccessResponse;
import com.interpark.global.error.code.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class SeatDetailController {

    private final SeatDetailService seatDetailService;

    @GetMapping("/date")
    public ResponseEntity<SuccessResponse<DateResponse>> getDatePerformance(){

        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, seatDetailService.getPerformance()));
    }
}

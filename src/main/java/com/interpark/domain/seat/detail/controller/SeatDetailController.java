package com.interpark.domain.seat.detail.controller;

import com.interpark.domain.seat.detail.dto.DateResponse;
import com.interpark.domain.seat.detail.dto.SeatPatchRequest;
import com.interpark.domain.seat.detail.dto.SeatResponse;
import com.interpark.domain.seat.detail.dto.SeatRowDto;
import com.interpark.domain.seat.detail.service.SeatDetailService;
import com.interpark.global.dto.SuccessResponse;
import com.interpark.global.error.code.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class SeatDetailController {

    private final SeatDetailService seatDetailService;

    // 좌석 상태 조회
    @GetMapping
    public ResponseEntity<SuccessResponse<SeatResponse>> getSeatStatus(){
        List<SeatRowDto> seatStatus = seatDetailService.getSeatStatus();

        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, new SeatResponse(seatStatus)));
    }

    // 좌석 선택
    @PatchMapping
    public ResponseEntity<SuccessResponse<SeatPatchRequest>> updateSeatStatus(@RequestBody SeatPatchRequest seatPatchRequest){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessResponse.of(SuccessCode.SUCCESS_CREATE,  seatDetailService.updateSeats(seatPatchRequest)));
    }

    @GetMapping("/date")
    public ResponseEntity<SuccessResponse<DateResponse>> getDatePerformance(){

        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, seatDetailService.getPerformance()));
    }
}

package com.interpark.domain.performance.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interpark.domain.performance.dto.GetHomeListResponse;
import com.interpark.domain.performance.service.PerformanceService;
import com.interpark.global.dto.SuccessResponse;
import com.interpark.global.error.code.SuccessCode;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/home")
@RequiredArgsConstructor
public class PerformanceController {
	private final PerformanceService performanceService;

	@GetMapping
	public ResponseEntity<SuccessResponse<?>> getHome(){
		List<GetHomeListResponse> getHomeListResponse = performanceService.getHomeList();

		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, getHomeListResponse));
	}
}

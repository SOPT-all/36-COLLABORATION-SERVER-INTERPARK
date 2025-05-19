package com.interpark.domain.payment.method.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interpark.domain.payment.method.dto.request.PayTicketRequest;
import com.interpark.domain.payment.method.dto.response.GetPaymentInfoResponse;
import com.interpark.domain.payment.method.dto.response.GetPaymentMethodListRes;
import com.interpark.domain.payment.method.service.PaymentService;
import com.interpark.global.dto.SuccessResponse;
import com.interpark.global.error.code.SuccessCode;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets/payment")
public class PaymentController {
	private final PaymentService paymentService;

	@GetMapping
	public ResponseEntity<SuccessResponse<?>> getPaymentMethod(){
		GetPaymentMethodListRes response = paymentService.getPaymentMethod();

		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, response));
	}

	@PostMapping
	public ResponseEntity<SuccessResponse<?>> payTicket(@RequestBody PayTicketRequest payTicketRequest){
		GetPaymentInfoResponse response = paymentService.getPaymentInfo(payTicketRequest);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_CREATE, response));
	}
}

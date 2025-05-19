package com.interpark.domain.payment.method.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.interpark.domain.payment.method.dto.response.GetPaymentMethodListRes;
import com.interpark.domain.payment.method.dto.response.GetPaymentMethodResponse;
import com.interpark.domain.payment.method.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
	private final PaymentRepository paymentRepository;

	public GetPaymentMethodListRes getPaymentMethod(){
		List<GetPaymentMethodResponse> getPaymentMethodResponse = paymentRepository.findAll()
			.stream()
			.map(GetPaymentMethodResponse::of)
			.toList();
		GetPaymentMethodListRes response = GetPaymentMethodListRes.of(getPaymentMethodResponse);
		return response;
	}
}

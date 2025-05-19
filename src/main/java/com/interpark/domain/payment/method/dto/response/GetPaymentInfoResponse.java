package com.interpark.domain.payment.method.dto.response;

import com.interpark.domain.payment.method.dto.request.PayTicketRequest;
import com.interpark.domain.payment.method.dto.request.UserInfoRequest;

import jakarta.validation.constraints.NotNull;

public record GetPaymentInfoResponse(
	int totalPrice,
	int ticketCount,
	String deliveryMethod,
	UserInfoRequest userInfo,
	String paymentMethod
) {
	public static GetPaymentInfoResponse of(PayTicketRequest payTicketRequest) {
		return new GetPaymentInfoResponse(payTicketRequest.totalPrice(), payTicketRequest.ticketCount(), payTicketRequest.deliveryMethod(), payTicketRequest.userInfo(), payTicketRequest.paymentMethod());
	}
}

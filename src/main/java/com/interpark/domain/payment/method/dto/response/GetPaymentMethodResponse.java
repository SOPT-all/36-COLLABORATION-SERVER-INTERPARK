package com.interpark.domain.payment.method.dto.response;

import com.interpark.domain.payment.method.entity.PaymentMethod;

public record GetPaymentMethodResponse(
	String name,
	String imageUrl
) {
	public static GetPaymentMethodResponse of(PaymentMethod paymentMethod) {
		return new GetPaymentMethodResponse(paymentMethod.getMethodName(), paymentMethod.getMethodImageUrl());
	}
}

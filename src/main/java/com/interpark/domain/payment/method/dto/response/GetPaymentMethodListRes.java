package com.interpark.domain.payment.method.dto.response;

import java.util.List;

public record GetPaymentMethodListRes(
	List<GetPaymentMethodResponse> paymentMethodList
) {
	public static GetPaymentMethodListRes of(List<GetPaymentMethodResponse> paymentMethodList) {
		return new GetPaymentMethodListRes(paymentMethodList);
	}
}

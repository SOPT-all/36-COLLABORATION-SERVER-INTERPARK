package com.interpark.domain.payment.method.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public record PayTicketRequest(
	@NotNull(message = "총금액은 필수 입력값입니다")
	int totalPrice,
	@NotNull(message = "티켓 개수는 필수 입력값입니다")
	int ticketCount,
	@NotNull(message = "티켓 수령 방법은 필수 입력값입니다")
	String deliveryMethod,
	@NotNull(message = "예매자 정보는 필수 입력값입니다")
	UserInfoRequest userInfo,
	@NotNull(message = "결제수단 정보는 필수 입력값입니다")
	String paymentMethod
) {
}

package com.interpark.domain.payment.method.dto.request;

public record UserInfoRequest(
	String name,
	String birth,
	String phoneNumber,
	String email
) {
}

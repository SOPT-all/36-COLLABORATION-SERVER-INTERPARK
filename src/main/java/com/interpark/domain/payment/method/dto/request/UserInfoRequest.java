package com.interpark.domain.payment.method.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserInfoRequest(
	@NotNull(message = "예매자의 이름은 필수 입력값입니다")
	String name,
	@NotNull(message = "예매자의 생일은 필수 입력값입니다")
	String birth,
	@NotNull(message = "예매자의 전화번호는 필수 입력값입니다")
	String phoneNumber,
	@NotNull(message = "예매자의 이메일은 필수 입력값입니다")
	@Email(message = "올바른 이메일 형식이 아닙니다")
	String email
) {
}

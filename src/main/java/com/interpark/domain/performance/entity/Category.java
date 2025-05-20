package com.interpark.domain.performance.entity;

import com.interpark.global.error.code.ErrorCode;
import com.interpark.global.error.exception.BusinessException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Category {
	GENRE("장르별 랭킹"),
	DISCOUNT("할인 중인 공연은 어때요?"),
	MD("MD PICK!"),
	KEYWORD("이런 키워드는 어때요?"),
	NOL("NOLPLAY"),
	SOON("곧 오픈하는 공연");

	private String name;

	public static Category fromName(String name) {
		for (Category category : values()) {
			if(category.name.equals(name)) {
				return category;
			}
		}
		throw new BusinessException(ErrorCode.DATA_NOT_FOUND);
	}
}

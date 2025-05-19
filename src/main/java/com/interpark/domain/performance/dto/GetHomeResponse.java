package com.interpark.domain.performance.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd", timezone = "Asia/Seoul")

@Builder
public record GetHomeResponse(
	Long id,
	String title,
	String imageUrl,
	String location,
	LocalDate startDate,
	LocalDate endDate,
	Integer discountRate,
	Integer price,
	String description,
	List<String> tagList
) {
}

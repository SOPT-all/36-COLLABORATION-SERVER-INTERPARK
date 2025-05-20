package com.interpark.domain.performance.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GetHomeListResponse(
	String category,
	List<String> keywordList,
	List<GetHomeResponse> getHomeResponseList
) {
	public static GetHomeListResponse of(String category, List<String> keywordList, List<GetHomeResponse> getHomeResponseList) {
		return new GetHomeListResponse(category, keywordList, getHomeResponseList);
	}
}

package com.interpark.domain.performance.service;



import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.interpark.domain.performance.dto.GetHomeListResponse;
import com.interpark.domain.performance.dto.GetHomeResponse;
import com.interpark.domain.performance.entity.Category;
import com.interpark.domain.performance.repository.PerformanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformanceService {
	private final PerformanceRepository performanceRepository;

	public List<GetHomeListResponse> getHomeList() {
		List<GetHomeListResponse> data = new ArrayList<>();

		// 장르별랭킹
		List<GetHomeResponse> genreList = performanceRepository.findAllByCategory(Category.GENRE)
			.stream()
			.map(p -> GetHomeResponse.builder()
				.id(p.getId())
				.title(p.getTitle())
				.imageUrl(p.getImageUrl())
				.location(p.getLocation())
				.startDate(p.getStartDate())
				.endDate(p.getEndDate())
				.build())
			.toList();
		data.add(GetHomeListResponse.of("장르별랭킹", List.of("뮤지컬", "콘서트", "스포츠"), genreList));

		// 할인 중인 공연
		List<GetHomeResponse> discountList = performanceRepository.findAllByCategory(Category.DISCOUNT)
			.stream()
			.map(p -> GetHomeResponse.builder()
				.id(p.getId())
				.title(p.getTitle())
				.imageUrl(p.getImageUrl())
				.location(p.getLocation())
				.startDate(p.getStartDate())
				.endDate(p.getEndDate())
				.discountRate(p.getDiscountRate())
                .price(p.getPrice())
				.description(p.getDescription())
				.build())
			.toList();
		data.add(GetHomeListResponse.of("할인 중인 공연은 어때요?", null, discountList));

		// MD PICK!
		List<GetHomeResponse> mdList = performanceRepository.findAllByCategory(Category.MD)
			.stream()
			.map(p -> GetHomeResponse.builder()
				.id(p.getId())
				.title(p.getTitle())
				.imageUrl(p.getImageUrl())
				.location(p.getLocation())
				.startDate(p.getStartDate())
				.endDate(p.getEndDate())
				.build())
			.toList();
		data.add(GetHomeListResponse.of("MD PICK!", List.of("오직 NOL 티켓에서만", "핫이슈 클래식 &무용", "화제의 전시", "해외공연"), mdList));

		// 키워드
		List<GetHomeResponse> keywordList = performanceRepository.findAllByCategory(Category.KEYWORD)
			.stream()
			.map(p -> GetHomeResponse.builder()
				.id(p.getId())
				.title(p.getTitle())
				.imageUrl(p.getImageUrl())
				.location(p.getLocation())
				.startDate(p.getStartDate())
				.endDate(p.getEndDate())
				.build())
			.toList();
		data.add(GetHomeListResponse.of("이런 키워드는 어때요?", List.of("👍🏻재관람률높은", "🧸아이와함께", "🤡대학로 연극 추천"), keywordList));

		// NOLPLAY
		List<GetHomeResponse> nolList = performanceRepository.findAllByCategory(Category.NOL)
			.stream()
			.map(p -> GetHomeResponse.builder()
				.id(p.getId())
				.title(p.getTitle())
				.imageUrl(p.getImageUrl())
				.build())
			.toList();
		data.add(GetHomeListResponse.of("NOLPLAY", List.of("뮤지컬", "콘서트", "스포츠"), nolList));

		// 곧오픈하는 공연
		List<GetHomeResponse> soonList = performanceRepository.findAllByCategory(Category.SOON)
			.stream()
			.map(p -> GetHomeResponse.builder()
				.id(p.getId())
				.title(p.getTitle())
				.imageUrl(p.getImageUrl())
				.startDate(p.getStartDate())
				.description(p.getDescription())
				.tagList(List.of("HOT", "단독판매"))
				.build())
			.toList();
		data.add(GetHomeListResponse.of("곧오픈하는공연", null, soonList));

		return data;
	}

}

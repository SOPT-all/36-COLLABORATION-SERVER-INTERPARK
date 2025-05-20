package com.interpark.domain.seat.detail.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public record PerformanceDto(
        String performanceTitle,
        String performanceLocation,
        String performanceImage,
        String performanceGenre,
        String runningTime,
        int ageLimit,
        @JsonFormat(pattern = "HH:mm")
        LocalTime performanceTime,
        String authors
) {
}

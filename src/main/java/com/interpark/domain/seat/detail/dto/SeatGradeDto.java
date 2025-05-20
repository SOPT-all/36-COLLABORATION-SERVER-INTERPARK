package com.interpark.domain.seat.detail.dto;

public record SeatGradeDto(
        String grade,
        int price,
        int seatCount
) {
}

package com.interpark.domain.seat.detail.dto;

import java.util.List;

public record SeatRowDto(
        String grade,
        int price,
        char row,
        List<Boolean> availability
) {}

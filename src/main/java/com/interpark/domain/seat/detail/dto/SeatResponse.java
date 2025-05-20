package com.interpark.domain.seat.detail.dto;

import java.util.List;

public record SeatResponse(
        List<SeatRowDto> seats
) {
}

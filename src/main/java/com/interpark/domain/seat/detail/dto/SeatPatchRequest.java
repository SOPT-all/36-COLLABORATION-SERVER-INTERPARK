package com.interpark.domain.seat.detail.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SeatPatchRequest(
        @NotNull(message = "좌석은 필수 입력값입니다")
    List<SeatPatchDto> seats
) {
}

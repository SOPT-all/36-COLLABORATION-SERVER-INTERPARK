package com.interpark.domain.seat.detail.dto;

import jakarta.validation.constraints.NotNull;

public record SeatPatchDto(
        @NotNull(message = "좌석 등급은 필수 입력값입니다")
        String grade,
        @NotNull(message = "좌석 열은 필수 입력값입니다")
        String row,
        @NotNull(message = "좌석 번호는 필수 입력값입니다")
        Integer number
) {
        public static SeatPatchDto of(String grade, char row, int number){
                return new SeatPatchDto(grade, String.valueOf(row), number);
        }
}

package com.interpark.domain.seat.detail.dto;

import java.util.List;

public record DateResponse(
    PerformanceDto performance,
    List<SeatGradeDto> seatGrades
) {
}

package com.interpark.domain.seat.detail.repository;

import com.interpark.domain.seat.detail.entity.SeatDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeatDetailRepository extends JpaRepository<SeatDetail, Long> {

    @Query("SELECT COUNT(sd) FROM SeatDetail sd WHERE sd.isSold = false And sd.seat.seatGrade = :seatGrade")
    int countByIsSoldAndSeatSeatGrade(String seatGrade);
}

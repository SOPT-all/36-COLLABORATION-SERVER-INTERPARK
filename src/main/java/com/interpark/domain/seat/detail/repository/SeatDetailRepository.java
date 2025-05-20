package com.interpark.domain.seat.detail.repository;

import com.interpark.domain.seat.detail.entity.SeatDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatDetailRepository extends JpaRepository<SeatDetail, Long> {
    @Query("SELECT sd FROM SeatDetail sd JOIN FETCH sd.seat")
    List<SeatDetail> findAllWithSeat();
}

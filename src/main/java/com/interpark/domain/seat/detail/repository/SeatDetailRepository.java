package com.interpark.domain.seat.detail.repository;

import com.interpark.domain.seat.detail.entity.SeatDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatDetailRepository extends JpaRepository<SeatDetail, Long> {
    @Query("SELECT sd FROM SeatDetail sd JOIN FETCH sd.seat")
    List<SeatDetail> findAllWithSeat();

    @Query("SELECT sd FROM SeatDetail sd WHERE sd.rowAlphabet = :rowAlphabet AND sd.seatNumber = :seatNumber")
    Optional<SeatDetail> findByRowAlphabetAndSeatNumber(char rowAlphabet, int seatNumber);
}

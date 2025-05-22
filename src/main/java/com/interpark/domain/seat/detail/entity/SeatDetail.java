package com.interpark.domain.seat.detail.entity;

import com.interpark.domain.reservation.entity.Reservation;
import com.interpark.domain.seat.entity.Seat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "seat_details")
public class SeatDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_detail_id")
    private Long id;

    @Column(nullable = false)
    private int seatNumber;         // 좌석 번호

    @Column(nullable = false)
    private boolean isSold;         // 매진 여부    (ex. 매진 => true)

    @Column(nullable = false)
    private char rowAlphabet;       // 좌석 열 (ex. 'A')

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;              // 좌석 (등급 및 가격 있는 테이블)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;        // 예매 정보

    @Builder
    public SeatDetail(int seatNumber, boolean isSold, char rowAlphabet,
                      Seat seat, Reservation reservation) {
        this.seatNumber = seatNumber;
        this.isSold = isSold;
        this.rowAlphabet = rowAlphabet;
        this.seat = seat;
        this.reservation = reservation;
    }

    public void setSold(boolean isSold) {
        this.isSold = isSold;
    }
}

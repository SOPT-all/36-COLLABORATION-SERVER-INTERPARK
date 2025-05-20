package com.interpark.domain.seat.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "seats")
public class Seat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private int id;

    @Column(nullable = false)
    private String seatGrade;       // 좌석 등급 (R, S)

    @Column(nullable = false)
    private int seatPrice;          // 좌석 가격 (ex. 18000)

    @Builder
    public Seat(String seatGrade, int seatPrice) {
        this.seatGrade = seatGrade;
        this.seatPrice = seatPrice;
    }
}

package com.interpark.domain.performance.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "performances")
public class Performance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "performance_id")
    private Long id;

    @Column(nullable = false)
    private String title;           // 공연 제목

    @Column(nullable = false)
    private String location;        // 공연 장소

    @Column(nullable = false)
    private String description;     // 공연 설명

    @Column(nullable = false)
    private LocalDate startDate;    // 시작 날짜 (yyyy-MM-dd)

    @Column(nullable = false)
    private LocalDate endDate;      // 종료 날짜 (yyyy-MM-dd)

    @Column(nullable = false)
    private int ageLimit;           // 관람 연령 (ex. 16 -> 만 16세 이상)

    @Column(nullable = false)
    private String runningTime;     // 공연 러닝타임 (180 -> 180분)

    @Column(nullable = false)
    private String imageUrl;        // 공연 사진 주소 (정적 리소스 주소 들어갈 예정)

    @Column(nullable = false)
    private int discountRate;       // 할인율 (ex. 50 -> 50%)

    @Builder
    public Performance(String title, String location, String description,
                       LocalDate startDate, LocalDate endDate, int ageLimit,
                       String runningTime, String imageUrl, int discountRate) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ageLimit = ageLimit;
        this.runningTime = runningTime;
        this.imageUrl = imageUrl;
        this.discountRate = discountRate;
    }
}

package com.interpark.domain.reservation.entity;

import com.interpark.domain.payment.method.detail.entity.PaymentMethodDetail;
import com.interpark.domain.performance.entity.Performance;
import com.interpark.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @Column(nullable = false)
    private LocalDateTime payTime;          // 결제 시간

    @Column(nullable = false)
    private String cashReceiptNumber;       // 현금 영수증 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;                      // 예매자

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_detail_id")
    private PaymentMethodDetail paymentMethodDetail;    // 결제 수단 상세

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;         // 공연 정보

    @Builder
    public Reservation(LocalDateTime payTime, String cashReceiptNumber, User user,
                       PaymentMethodDetail paymentMethodDetail, Performance performance) {
        this.payTime = payTime;
        this.cashReceiptNumber = cashReceiptNumber;
        this.user = user;
        this.paymentMethodDetail = paymentMethodDetail;
        this.performance = performance;
    }
}

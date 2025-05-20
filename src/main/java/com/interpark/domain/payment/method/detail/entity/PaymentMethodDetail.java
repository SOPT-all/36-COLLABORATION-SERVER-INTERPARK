package com.interpark.domain.payment.method.detail.entity;

import com.interpark.domain.payment.method.entity.PaymentMethod;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "payment_method_details")
public class PaymentMethodDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_detail_id")
    private Long id;

    @Column(nullable = false)
    private String detailInfo;      // 결제수단 상세명

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;        // 결제수단 고유번호

    @Builder
    public PaymentMethodDetail(String detailInfo, PaymentMethod paymentMethod) {
        this.detailInfo = detailInfo;
        this.paymentMethod = paymentMethod;
    }
}

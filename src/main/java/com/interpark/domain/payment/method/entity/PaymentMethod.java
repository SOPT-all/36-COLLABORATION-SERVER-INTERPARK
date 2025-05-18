package com.interpark.domain.payment.method.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment-method_id")
    private Long id;

    @Column(nullable = false)
    private String methodName;      // 결제 수단명

    @Column(nullable = false)
    private String methodImageUrl;  // 결제 수단 이미지 주소 (정적 리소스)

    @Builder
    public PaymentMethod(String methodName, String methodImageUrl) {
        this.methodName = methodName;
        this.methodImageUrl = methodImageUrl;
    }
}

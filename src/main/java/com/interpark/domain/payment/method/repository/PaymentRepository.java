package com.interpark.domain.payment.method.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interpark.domain.payment.method.entity.PaymentMethod;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentMethod, Long> {
}

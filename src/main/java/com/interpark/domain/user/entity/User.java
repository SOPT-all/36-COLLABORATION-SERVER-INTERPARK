package com.interpark.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(nullable = false)
    private String name;            // 예매자 이름
    @Column(nullable = false)
    private LocalDate birthday;     // 예매자 생년월일
    @Column(nullable = false)
    private String phone;           // 예매자 핸드폰 번호 (010-xxxx-xxxx)
    @Column(nullable = false)
    private String email;           // 예매자 이메일 (ex. example@naver.com)

    @Builder
    public User(String name, LocalDate birthday, String phone, String email) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }
}

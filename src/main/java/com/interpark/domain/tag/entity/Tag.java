package com.interpark.domain.tag.entity;

import com.interpark.domain.performance.entity.Performance;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tags")
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(nullable = false)
    private String tagName;  // 태그명

    @ManyToOne(targetEntity = Performance.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id", nullable = true)
    private Performance performance;

    @Builder
    public Tag(String tagName, Performance performance) {
        this.tagName = tagName;
        this.performance = performance;
    }
}

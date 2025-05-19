package com.interpark.domain.performancetag.entity;

import com.interpark.domain.performance.entity.Performance;
import com.interpark.domain.tag.entity.Tag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "performance_tags")
public class PerformanceTag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "performance_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;                            // tags 테이블

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;            // performances 테이블

    @Builder
    public PerformanceTag(Performance performance, Tag tag) {
        this.performance = performance;
        this.tag = tag;
    }

}

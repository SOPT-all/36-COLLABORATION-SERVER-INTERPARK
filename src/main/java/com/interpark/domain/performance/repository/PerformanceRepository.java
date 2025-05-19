package com.interpark.domain.performance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interpark.domain.performance.entity.Category;
import com.interpark.domain.performance.entity.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
	List<Performance> findAllByCategory(Category category);
}

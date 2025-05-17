package com.interpark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        // 스프링부트 2.4.0부터 allowCredentials가 true일 때 allowedOrigins에 특수 값인 " * " 추가할 수 없게 되었음.
        config.addAllowedOriginPattern("*");    // addAllowedOrigin("*") 대신 사용
        config.addAllowedHeader("*");           // 모든 헤더 허용
        config.addAllowedMethod("*");           // 모든 HTTP 메서드 허용 (POST, GET, PUT, DELETE, PATCH, OPTION)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);    // '/**' 경로에 모든 설정 적용

        return new CorsFilter(source);
    }
}

package com.example.goodsprovider;

import com.netflix.hystrix.HystrixMetrics;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.example.goodsprovider.dao")
@EnableCircuitBreaker
public class GoodsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsProviderApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registration = new ServletRegistrationBean(servlet);
        registration.setName("HystrixMetricsStreamServlet");
        registration.setLoadOnStartup(1);
        registration.addUrlMappings("/hystrix.stream");
        return registration;
    }
}

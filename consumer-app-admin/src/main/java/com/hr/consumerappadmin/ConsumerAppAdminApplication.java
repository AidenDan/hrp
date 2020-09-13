package com.hr.consumerappadmin;

import com.hr.consumerappadmin.config.RsaKeyProperties;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard //对某一个支持熔断的服务进行监测
@EnableCircuitBreaker
@MapperScan("com.hr.mapper")
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ConsumerAppAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAppAdminApplication.class, args);
    }

    //springboot 版本如果是2.0则需要添加 ServletRegistrationBean
    // 因为springboot的默认路径不是 "/hystrix.stream"
    @Bean
    public ServletRegistrationBean getServletConsumer() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}

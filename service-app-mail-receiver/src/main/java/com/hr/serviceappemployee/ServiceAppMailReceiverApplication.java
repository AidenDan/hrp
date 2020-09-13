package com.hr.serviceappemployee;

import com.hr.model.MailConstants;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker //对Hystrix熔断机制的支持
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
public class ServiceAppMailReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAppMailReceiverApplication.class, args);
    }

    // springboot 版本如果是2.0则需要添加 ServletRegistrationBean
    // 因为springboot的默认路径不是 "/hystrix.stream"
    @Bean
    public ServletRegistrationBean getServletMailReceiver() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

    @Bean
    Queue queue() {
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }
}

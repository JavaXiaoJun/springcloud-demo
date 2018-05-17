package com.study;

import com.study.component.ZipkinLinkFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Created by lf52 on 2018/5/5.
 *
 * Feign声明式的服务调用;采用基于接口的注解,使用robbin实现负载均衡
 * 整合Hystrix实现服务调用层级的熔断
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FeignManager {

    public static void main(String[] args) {
        SpringApplication.run(FeignManager.class, args);
    }

    @Bean
    public ZipkinLinkFilter zipkinLinkFilter() {
        return new ZipkinLinkFilter();
    }
}

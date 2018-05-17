package com.study;

import com.study.component.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by lf52 on 2018/5/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulManager {

    public static void main(String[] args) {
        SpringApplication.run(ZuulManager.class, args);
    }

    @Bean
    public MyFilter myFilter(){
        return new MyFilter();
    }

}

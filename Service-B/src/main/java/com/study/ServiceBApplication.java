package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by lf52 on 2018/5/2.
 */
@SpringBootApplication
@EnableEurekaClient
@RemoteApplicationEventScan(basePackages = "com.study.bus.event")//用于发现自定义总线事件
public class ServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBApplication.class, args);
    }

}

package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by lf52 on 2018/5/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages={"com.study.dao","com.newegg.ec.core"})
public class ServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }

}

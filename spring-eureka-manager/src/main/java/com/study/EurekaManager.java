package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 单机模式eureka服务端(也可以通过配置多个.yml文件实现HA)
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaManager {
    public static void main(String[] args) {
        SpringApplication.run(EurekaManager.class, args);
    }
}

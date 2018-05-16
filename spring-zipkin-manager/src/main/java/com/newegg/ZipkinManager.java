package com.newegg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * Created by lf52 on 2018/5/16.
 */
@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class ZipkinManager {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinManager.class, args);
    }
}

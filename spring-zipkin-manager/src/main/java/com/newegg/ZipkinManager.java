package com.newegg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;

/**
 * Created by lf52 on 2018/5/16.
 *
 * spring cloud sleuth进阶功能
 *    1.链路数据落地（mysql，es等）
 *    2.在链路数据中添加自定义数据（基于ZuulFilter实现链路自定义数据埋点）
 *    3.使用消息队列代替http进行链路通讯（rabbitmq，kafka等）
 */
@SpringBootApplication
@EnableZipkinStreamServer //如果使用zipkin-streamjar则使用该注解代替 @EnableZipkinServer
@EnableDiscoveryClient
public class ZipkinManager {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinManager.class, args);
    }

    //开启mysql数据写入支持
    @Bean
    @Primary
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
    }

}

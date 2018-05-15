package com.study.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by lf52 on 2018/5/15.
 */
@Component
public class HystrixService {

    @HystrixCommand(commandProperties = {
                            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
                            @HystrixProperty(name = "execution.timeout.enabled", value = "true")},
                    threadPoolProperties = {
                            @HystrixProperty(name = "coreSize", value = "10"),
                            @HystrixProperty(name = "maxQueueSize", value = "-1")
                    },fallbackMethod = "queryHbaseFallback")//fallbackMethod=回退时执行的方法
    public String queryHbase(int num){

        try {
            int i = new Random().nextInt(500);
            System.out.println("sleep time : " + i);
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  num + " query hbase success .";
    }

    public String queryHbaseFallback(int num){
        System.out.println(num + " query hbase time out .");
        return  " query hbase time out .";
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "true")},
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "-1")
            },fallbackMethod = "queryHbaseAsyncFallback")//fallbackMethod=回退时执行的方法
    public Future<String> queryHbaseAsync(int num) {

        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return  num + " query hbase success .";
            }
        };

    }

    public String queryHbaseAsyncFallback(int num){
        return  num + " query hbase time out .";
    }

}

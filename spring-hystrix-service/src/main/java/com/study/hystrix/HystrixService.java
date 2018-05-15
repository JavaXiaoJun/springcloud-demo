package com.study.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by lf52 on 2018/5/15.
 */
@Component
public class HystrixService {

    @HystrixCommand(fallbackMethod = "queryHbaseFallback")//fallbackMethod=回退时执行的方法
    public String queryHbase(){

        try {
            System.out.println("******************start***********************");
            int num = new Random().nextInt(1000);
            System.out.println("sleep time : " + num);
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("******************end***********************");
        }
        return  " query hbase success .";
    }

    public String queryHbaseFallback(){
        return  " query hbase time out .";
    }
}

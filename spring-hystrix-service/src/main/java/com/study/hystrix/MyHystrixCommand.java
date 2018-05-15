package com.study.hystrix;

import com.netflix.hystrix.*;

import java.util.Random;

/**
 * Created by lf52 on 2018/5/15.
 *
 * 原生hystrix的使用用例
 */
public class MyHystrixCommand extends HystrixCommand<String> {

    private String name;

    public MyHystrixCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))  //必须
                  .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                          .withExecutionTimeoutInMilliseconds(500)) //timeout时间,超时快速响应失败
                  .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleGroup-pool"))  //可选,默认 使用 this.getClass().getSimpleName();
                  .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                          .withCoreSize(5) // 线程池大小设置
                          .withMaxQueueSize(-1)// 线程值等待队列长度,-1 表示不排队立刻响应失败
                          //.withQueueSizeRejectionThreshold(7) //队列reject阈值，maxQueueSize>0时才生效，一般设置为小于maxQueueSizede的数值
             ));

        this.name = name;
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    protected String run() throws Exception {
        int num = new Random().nextInt(1000);
        //System.out.println(name + "sleep time : " + num);
        //Thread.sleep(num);
        System.out.println("query datasource success , hi : " + name);
        return  "query datasource success , hi : " + name;
    }

    /**
     * 设置失败时的反馈
     * @return
     */
    @Override
    protected String getFallback(){
            System.out.println("query datasource time out , fallback : " + name);
            return "query datasource time out , fallback : " + name;
    }

}

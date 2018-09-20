package com.study.hystrix;

/**
 * Created by lf52 on 2018/9/20.
 */
public class MyHystrixCommand<T> extends  AbstractHystrixCommand<T> {

    public MyHystrixCommand(HystrixHandler handler, HystrixParam param) {
        super(handler, param);
    }

}

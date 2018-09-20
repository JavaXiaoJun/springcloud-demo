package com.study.hystrix;

/**
 * Created by lf52 on 2018/8/22.
 */
public interface HystrixHandler<T> {

    T run() throws Exception;

    T fallback();
}

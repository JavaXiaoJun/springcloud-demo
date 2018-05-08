package com.study.feign.hystric;

import com.study.feign.SchedualServiceB;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lf52 on 2018/5/5.
 */
@Component
public class SchedualServiceBHystric implements SchedualServiceB{

    /**
     * 20 failures in 5 seconds is the default in Hystrix
     * 实现FeignClient接口，定义调用服务失败是的快速响应机制
     * @param name 接口需要的参数
     * @return
     */
    @Override
    public String sayHelloFromClient(@RequestParam(value = "name") String name) {
        return "sorry "+ name +" ，call service-b fail";
    }
}

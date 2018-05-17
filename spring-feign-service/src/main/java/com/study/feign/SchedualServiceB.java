package com.study.feign;

import com.study.feign.hystric.SchedualServiceBHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lf52 on 2018/5/5.
 * @FeignClient 对应的服务名称
 * @RequestMapping controller对应的接口名称
 */
@FeignClient(value = "Service-B",fallback = SchedualServiceBHystric.class)
public interface SchedualServiceB {
    /**
     * 调用Service-B服务的hello接口
     * @param name 接口需要的参数
     * @return
     */
    @RequestMapping(value = "/helloworld")
    String sayHelloFromClient(@RequestParam(value = "name") String name);

}

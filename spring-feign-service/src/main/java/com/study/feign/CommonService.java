package com.study.feign;

import com.study.common.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lf52 on 2018/5/5.
 * @FeignClient 对应的服务名称
 * @RequestMapping controller对应的接口名称
 */
@FeignClient(value = "Service-B")
public interface CommonService {

    @RequestMapping(value = "/hello1")
    User sayHello1FromClient(@RequestParam(value = "name") String name,@RequestParam(value = "city") String city,@RequestParam(value = "age") Integer age);

    @RequestMapping(value = "/hello2")
    String sayHello2FromClient(@RequestBody User user);

}

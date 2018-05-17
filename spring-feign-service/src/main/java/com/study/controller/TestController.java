package com.study.controller;

import com.study.common.model.User;
import com.study.feign.CommonService;
import com.study.feign.SchedualServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lf52 on 2018/5/5.
 */
@RestController
public class TestController {

    @Autowired
    SchedualServiceB schedualServiceb;

    @Autowired
    CommonService commonService;

    @Value("${server.port}")
    String port;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        System.err.println("Service Feign  hello "+name+",i am from port:" +port);
        return schedualServiceb.sayHelloFromClient(name);
    }

    @RequestMapping(value = "/hello1")
    public User sayHello1FromClient(@RequestParam(value = "name") String name,@RequestParam(value = "city") String city,@RequestParam(value = "age") Integer age){
        return commonService.sayHello1FromClient(name,city,age);
    }

    @RequestMapping(value = "/hello2")
    public String sayHello2FromClient(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("Service-B");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());// 打印当前调用服务的信息
        User user = new User("wuhu",18,"leofu");
        return commonService.sayHello2FromClient(user);
    }
}

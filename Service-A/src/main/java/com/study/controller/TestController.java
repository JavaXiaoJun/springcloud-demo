package com.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lf52 on 2018/5/2.
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String home(@RequestParam String name) {
        return "hello "+name+",i am from port:" +port;
    }


    @Value("${propname}")
    String propname;

    @RequestMapping("/getProperties")
    public String getProperties(){
        return "Service A Get name from git : " + propname;
    }

}

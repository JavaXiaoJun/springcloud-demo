package com.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lf52 on 2018/5/2.
 */
@RestController
public class TestController {

  /*  @Value("${server.port}")
    String port;*/

    @RequestMapping("/hello")
    public String home() {

        return "Service A hello leo,i am from port:" + 8222;
    }

}

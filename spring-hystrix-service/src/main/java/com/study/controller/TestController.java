package com.study.controller;

import com.study.hystrix.HystrixService;
import com.study.hystrix.MyHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lf52 on 2018/5/15.
 */
@RestController
public class TestController {

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public String query(){
        return  hystrixService.queryHbase();
    }

    @RequestMapping(value = "/hystrix",method = RequestMethod.GET)
    public String hystrix() throws InterruptedException {

         int count =10;
         while (count > 0){
                int num = count--;
                new Thread(() -> {
                    try {
                        new MyHystrixCommand("leo"+num).execute();
                    }catch (Exception ex){
                         System.out.println("Exception:"+ex.getMessage()+" name=" + "leo"+num);
                    }
                }).start();
         }

        return  "success";
    }
}

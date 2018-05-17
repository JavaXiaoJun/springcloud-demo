package com.study.controller;

import com.study.bus.event.MyRemoteEvent;
import com.study.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by lf52 on 2018/5/2.
 */
@RestController
@RefreshScope
public class TestController {

    //注入ApplicationContext,通过ApplicationContext来publish remote event
    @Autowired
    private ApplicationContext context;

    /**
     * for zuul test
     * @param name
     * @return
     */
    @RequestMapping("/hello")
    public String home(@RequestParam String name) {
        return "Service B hello "+name+",i am from port:" +port;
    }

    /**
     * for test feign param banding
     */
    @Value("${server.port}")
    String port;
    @RequestMapping("/helloworld")
    public String hello(@RequestParam(value = "name") String name) throws InterruptedException {
        System.out.println("******************start***********************");
        int num = new Random().nextInt(500);
        System.out.println("sleep time : " + num);
        Thread.sleep(num);
        System.out.println("******************end***********************");
        return "hello "+name+",i am from port:" +port;
    }

    @RequestMapping("/hello1")
    public User hello1(@RequestParam(value = "name") String name,@RequestParam(value = "city") String city,@RequestParam(value = "age") Integer age) {
        return new User(city,age,name);
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.POST)
    public String hello2(@RequestBody User user) throws InterruptedException {
        return user.toString();
    }

    /**
     * for test spring config
     */
    @Value("${propname}")
    String propname;
    @RequestMapping("/getProperties")
    public String getProperties(){
        return "Service B : " + port +" Get name from git : " + propname;
    }

    /**
     * for test spring cloud bus
     * @param destination 用于指定某个client去接收推送消息（不指定则推送给所有client）
     * @return
     */
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public String publish(@RequestParam(value = "destination", required = false, defaultValue = "**") String destination) {

        final String myUniqueId = context.getId();

        final MyRemoteEvent event = new MyRemoteEvent(this, myUniqueId, destination, "hello world");
        //因为我们在启动类上设置了@RemoteApplicationEventScan注解，所以通过context发送的事件将变成一个bus event总线事件，而不是在自身context中发布的一个ApplicationEvent
        context.publishEvent(event);

        return "event published";
    }

}

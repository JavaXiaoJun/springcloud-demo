package com.study.controller;

import com.netflix.discovery.shared.Application;
import com.netflix.eureka.EurekaServerContext;
import com.netflix.eureka.EurekaServerContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lf52 on 2018/5/8.
 */
@Controller
public class RestController {

    private EurekaServerContext getServerContext() {
        return EurekaServerContextHolder.getInstance().getServerContext();
    }

    /**
     * 所有获取注册的服务
     * @return
     */
    @RequestMapping(value="/getRegistryApps",method= RequestMethod.GET)
    @ResponseBody
    public List<Application> getRegistryApps(){
        List<Application> sortedApplications = getServerContext().getRegistry().getSortedApplications();
        System.err.println(sortedApplications);
        return sortedApplications;
    }
}

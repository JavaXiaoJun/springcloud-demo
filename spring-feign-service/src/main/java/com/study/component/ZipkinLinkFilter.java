package com.study.component;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

/**
 * Created by lf52 on 2018/5/16.
 * 在链路数据中添加自定义数据
 */
@Component
public class ZipkinLinkFilter extends ZuulFilter {

    @Autowired
    private Tracer tracer;

    /**
     * 过滤器的生命周期
     *  pre：可以在请求被路由之前调用
        route：在路由请求时候被调用
        post：在route和error过滤器之后被调用
        error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
         return "pre";
    }

    /**
     * 优先级为0，数字越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 该方法返回true时，run()方法才会被调用
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 给链路添加operator，同时持久化traceId到数据库
     * @return
     */
    @Override
    public Object run() {
        tracer.addTag("operator", "leofu");
        System.out.print("the traceId is " + tracer.getCurrentSpan().traceIdString());
        return null;
    }
}

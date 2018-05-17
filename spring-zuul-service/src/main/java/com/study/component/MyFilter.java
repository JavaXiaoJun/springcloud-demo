package com.study.component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lf52 on 2018/5/17.
 */
public class MyFilter extends ZuulFilter {

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
        return "post";
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

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //打印本次request相关信息
        System.err.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        //在链路数据中添加自定义数据
        tracer.addTag("operator", "leofu");
        return null;
    }

}

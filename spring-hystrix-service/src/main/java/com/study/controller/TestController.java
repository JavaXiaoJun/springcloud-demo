package com.study.controller;

import com.study.hystrix.HystrixHandler;
import com.study.hystrix.HystrixParam;
import com.study.hystrix.HystrixService;
import com.study.hystrix.MyHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by lf52 on 2018/5/15.
 */
@RestController
public class TestController {

    @Autowired
    private HystrixService hystrixService;

    /**
     * spring cloud hystrix
     * @return
     */
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public String query(){

        int count =15;
        while (count > 0){
            int num = count--;
            new Thread(() -> {
                try {
                    hystrixService.queryHbase(num);
                }catch (Exception ex){
                    System.out.println("Exception:"+ex.getMessage());
                }
            }).start();
        }

        return  "success";
    }

    /**
     * spring cloud hystrix aynsc
     * @return
     */
    @RequestMapping(value = "/queryAnysc",method = RequestMethod.GET)
    public String queryAnysc(){

        //模拟并发为15个request的场景，我们hystrix池大小为10，因此有5个请求会快速响应失败
        int count =5;
        while (count > 0){
            int num = count--;
            new Thread(() -> {
                try {
                    List<Future<String>> futureList = new ArrayList();
                    futureList.add(hystrixService.queryHbaseAsync(num));
                    futureList.add(hystrixService.queryHbaseAsync(num));
                    futureList.add(hystrixService.queryHbaseAsync(num));
                    futureList.forEach(future -> {
                        try {
                            System.out.println(Thread.currentThread().getName()+" : "+future.get());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }catch (Exception ex){
                    System.out.println("Exception:"+ex.getMessage());
                }
            }).start();
        }

        return  "success";
    }

    /**
     * 原生hystrix test
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = "/hystrix",method = RequestMethod.GET)
    public String hystrix() throws InterruptedException {

         //模拟并发为15个request的场景，我们hystrix池大小为10，因此有5个请求会快速响应失败
         int count =15;
         while (count > 0){
                int num = count--;
                new Thread(() -> {
                    try {
                        List<Future<String>> futureList = new ArrayList(10);
                        //String result = new MyHystrixCommand("leo"+num).execute();//同步阻塞的方式执行
                        //异步非堵塞的方式执行
                        futureList.add(new MyHystrixCommand<String>(new HystrixHandler() {
                            @Override
                            public String run() throws Exception {
                                String name = Thread.currentThread().getName();
                                int num = new Random().nextInt(1000);
                                Thread.sleep(num);
                                System.out.println(name + " sleep time : " + num);
                                System.out.println(name + " query datasource success , hi : leo");
                                return name + " query datasource success , hi : leo";
                            }

                            @Override
                            public String fallback() {
                                   String name = Thread.currentThread().getName();
                                   System.out.println(name + " query datasource time out , fallback : leo");
                                   return name + " query datasource time out , fallback : leo";
                            }
                        },new HystrixParam()).queue());

                        futureList.forEach(future -> {
                            try {
                               future.get();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }catch (Exception ex){
                         System.out.println("Exception:"+ex.getMessage()+" name=" + "leo" + num);
                    }
                }).start();
         }

        return  "success";
    }
}

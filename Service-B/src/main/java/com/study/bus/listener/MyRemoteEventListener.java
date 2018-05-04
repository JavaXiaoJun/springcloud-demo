package com.study.bus.listener;

import com.study.bus.event.MyRemoteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by lf52 on 2018/5/4.
 * 自定义总线事件侦听
 */
@Component
public class MyRemoteEventListener  implements ApplicationListener<MyRemoteEvent> {

    @Override
    public void onApplicationEvent(MyRemoteEvent event) {
        System.out.println("Received MyRemoteEvent - message: " + event.getMessage());
    }

}

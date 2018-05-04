package com.study.bus.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * Created by lf52 on 2018/5/4.
 * 自定义消息总线事件
 */
public class MyRemoteEvent<T> extends RemoteApplicationEvent {

    private T message;

    //jackson序列化反序列化必须有无参构造函数
    public MyRemoteEvent() {}

    /**
     * @param source 发布事件的对象
     * @param originService 发布者的唯一上下文ID
     * @param destinationService
     * @param message
     */
    public MyRemoteEvent(Object source, String originService, String destinationService, T message) {
        super(source, originService, destinationService);
        this.message = message;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

}

package com.study.hystrix;

import com.netflix.hystrix.*;

/**
 * Created by lf52 on 2018/5/15.
 *
 * 原生hystrix的使用用例
 */
public abstract class AbstractHystrixCommand<T> extends HystrixCommand<T> {

    private HystrixHandler<T> hystrixHandler;

    public AbstractHystrixCommand(HystrixHandler handler, HystrixParam param) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(param.getGroupKey()))
                //设置当前command的key,默认值为当前类名
                .andCommandKey(HystrixCommandKey.Factory.asKey(param.getCommandKey()))
                        // 超时时间，单位默认1000ms
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                                .withExecutionTimeoutInMilliseconds(param.getTimeout())
                                        // 断路器是否启用，默认true
                                .withCircuitBreakerEnabled(param.isCircuitBreakerEnable())
                                        // 请求量阈值，请求量达到该值是会开启断路器，滑动窗口的大小，默认为20
                                .withCircuitBreakerRequestVolumeThreshold(param.getCircuitBreakerRequestVolumeThreshold())
                                        // 断路器打开后，会直接拒绝请求，此时间是配置多长时候后再次尝试处理请求
                                .withCircuitBreakerSleepWindowInMilliseconds(param.getCircuitBreakerSleepWindowInMilliseconds())
                                        // 打开断路器并走回退逻辑的错误率，默认50%
                                .withCircuitBreakerErrorThresholdPercentage(param.getCircuitBreakerErrorThresholdPercentage())
                                        // 该时间用于断路器判断健康度时需要收集信息的持续时间(滚动时间窗)
                                .withMetricsRollingStatisticalWindowInMilliseconds(param.getMetricsRollingStatisticalWindowInMilliseconds())
                                        // 设置滚动时间窗统计指标信息时代划分“桶”的数量
                                .withMetricsRollingPercentileBucketSize(param.getMetricsRollingPercentileBucketSize())
                )
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(param.getThreadPoolKey()))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                                // 设置核心线程池大小，默认为10
                                .withCoreSize(param.getCoreSize())
                                        // 设置此项为 true，最大线程池数才生效，默认false
                                .withAllowMaximumSizeToDivergeFromCoreSize(param.isAllowMaximumSizeToDivergeFromCoreSize())
                                        // 最大线程池数，默认10
                                .withMaximumSize(param.getMaxPoolSize())
                                        // 设置保持存活的时间，单位是分钟，默认是1
                                .withKeepAliveTimeMinutes(param.getKeepAliveTimeMinutes())
                                        // 设置当前线程池的等待队列的大小，默认为5
                                .withMaxQueueSize(param.getQueueSize())
                                        // queue 拒绝大小, 即使maxQueueSize没有达到，达到queueSizeRejectionThreshold该值后，请求也会被拒绝。
                                .withQueueSizeRejectionThreshold(param.getRejectQueueSize())
                ));

        this.hystrixHandler = handler;
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    protected final T run() throws Exception {
        return hystrixHandler.run();
    }

    /**
     * 设置失败时的反馈
     * @return
     */
    @Override
    protected final T getFallback(){
        return hystrixHandler.fallback();
    }

}

package com.study.hystrix;

/**
 * Created by lf52 on 2018/8/22.
 */
public class HystrixParam {

    private String groupKey = "defaultGroup";

    private String commandKey = "defaultCommand";

    private String threadPoolKey = "defaultThreadPool";

    private int timeout = 500;

    private int coreSize = 10;

    private boolean allowMaximumSizeToDivergeFromCoreSize = true;

    private int maxPoolSize = 10;

    private int keepAliveTimeMinutes = 1;

    private int queueSize = -1;

    private int rejectQueueSize = 0;

    private boolean circuitBreakerEnable = true;

    private int circuitBreakerRequestVolumeThreshold = 100;

    private int circuitBreakerSleepWindowInMilliseconds = 30000;

    private int circuitBreakerErrorThresholdPercentage = 60;

    private int metricsRollingStatisticalWindowInMilliseconds = 10000;

    private int metricsRollingPercentileBucketSize = 20;

    public HystrixParam() {}

    public HystrixParam(String groupKey, String commandKey, String threadPoolKey, int timeout, int coreSize, int maxPoolSize, int queueSize, int rejectQueueSize) {
        this.groupKey = groupKey;
        this.commandKey = commandKey;
        this.threadPoolKey = threadPoolKey;
        this.timeout = timeout;
        this.coreSize = coreSize;
        this.maxPoolSize = maxPoolSize;
        this.queueSize = queueSize;
        this.rejectQueueSize = rejectQueueSize;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getCommandKey() {
        return commandKey;
    }

    public void setCommandKey(String commandKey) {
        this.commandKey = commandKey;
    }

    public String getThreadPoolKey() {
        return threadPoolKey;
    }

    public void setThreadPoolKey(String threadPoolKey) {
        this.threadPoolKey = threadPoolKey;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public boolean isAllowMaximumSizeToDivergeFromCoreSize() {
        return allowMaximumSizeToDivergeFromCoreSize;
    }

    public void setAllowMaximumSizeToDivergeFromCoreSize(boolean allowMaximumSizeToDivergeFromCoreSize) {
        this.allowMaximumSizeToDivergeFromCoreSize = allowMaximumSizeToDivergeFromCoreSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getKeepAliveTimeMinutes() {
        return keepAliveTimeMinutes;
    }

    public void setKeepAliveTimeMinutes(int keepAliveTimeMinutes) {
        this.keepAliveTimeMinutes = keepAliveTimeMinutes;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public int getRejectQueueSize() {
        return rejectQueueSize;
    }

    public void setRejectQueueSize(int rejectQueueSize) {
        this.rejectQueueSize = rejectQueueSize;
    }

    public boolean isCircuitBreakerEnable() {
        return circuitBreakerEnable;
    }

    public void setCircuitBreakerEnable(boolean circuitBreakerEnable) {
        this.circuitBreakerEnable = circuitBreakerEnable;
    }

    public int getCircuitBreakerRequestVolumeThreshold() {
        return circuitBreakerRequestVolumeThreshold;
    }

    public void setCircuitBreakerRequestVolumeThreshold(int circuitBreakerRequestVolumeThreshold) {
        this.circuitBreakerRequestVolumeThreshold = circuitBreakerRequestVolumeThreshold;
    }

    public int getCircuitBreakerSleepWindowInMilliseconds() {
        return circuitBreakerSleepWindowInMilliseconds;
    }

    public void setCircuitBreakerSleepWindowInMilliseconds(int circuitBreakerSleepWindowInMilliseconds) {
        this.circuitBreakerSleepWindowInMilliseconds = circuitBreakerSleepWindowInMilliseconds;
    }

    public int getCircuitBreakerErrorThresholdPercentage() {
        return circuitBreakerErrorThresholdPercentage;
    }

    public void setCircuitBreakerErrorThresholdPercentage(int circuitBreakerErrorThresholdPercentage) {
        this.circuitBreakerErrorThresholdPercentage = circuitBreakerErrorThresholdPercentage;
    }

    public int getMetricsRollingStatisticalWindowInMilliseconds() {
        return metricsRollingStatisticalWindowInMilliseconds;
    }

    public void setMetricsRollingStatisticalWindowInMilliseconds(int metricsRollingStatisticalWindowInMilliseconds) {
        this.metricsRollingStatisticalWindowInMilliseconds = metricsRollingStatisticalWindowInMilliseconds;
    }

    public int getMetricsRollingPercentileBucketSize() {
        return metricsRollingPercentileBucketSize;
    }

    public void setMetricsRollingPercentileBucketSize(int metricsRollingPercentileBucketSize) {
        this.metricsRollingPercentileBucketSize = metricsRollingPercentileBucketSize;
    }
}

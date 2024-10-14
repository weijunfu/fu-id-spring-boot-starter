package com.ijunfu.id.property;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Title : 雪花算法配置类
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024-10-14 17:20
 * @Version: 1.0
 * @Motto : 世界很大 世界很小
 */
@ConfigurationProperties(prefix = "fu.snowflake")
public class SnowflakeProperties {

    private int workerId = 1;
    private int dataCenterId = 1;
    private boolean enabled = false;

    public SnowflakeProperties() {
    }

    public SnowflakeProperties(int workerId, int dataCenterId) {
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(int dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "SnowflakeProperties{" +
                "workerId=" + workerId +
                ", dataCenterId=" + dataCenterId +
                ", enabled=" + enabled +
                '}';
    }
}

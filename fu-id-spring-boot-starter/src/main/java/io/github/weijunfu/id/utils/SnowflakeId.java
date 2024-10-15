package io.github.weijunfu.id.utils;

/**
 * 雪花算法ID生成类
 * @author ijunfu
 * @version 1.0.0
 *
 */
public class SnowflakeId {

    // 定义几个关键的常量
    private final long twepoch = 1288834974657L; // 开始时间戳 (自定义)
    private final long workerIdBits = 5L;        // 机器ID所占的位数
    private final long datacenterIdBits = 5L;    // 数据中心ID所占的位数
    private final long maxWorkerId = ~(-1L << workerIdBits);   // 支持的最大机器ID，结果是31 (从0开始)
    private final long maxDatacenterId = ~(-1L << datacenterIdBits);  // 支持的最大数据中心ID
    private final long sequenceBits = 12L;       // 序列号所占的位数
    private final long workerIdShift = sequenceBits;  // 机器ID左移位数
    private final long datacenterIdShift = sequenceBits + workerIdBits;  // 数据中心ID左移位数
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits; // 时间戳左移位数
    private final long sequenceMask = ~(-1L << sequenceBits);   // 4095, 用来屏蔽序列号
    private long workerId;       // 当前机器ID
    private long datacenterId;   // 当前数据中心ID
    private long sequence = 0L;  // 当前毫秒内的序列(0~4095)
    private long lastTimestamp = -1L;  // 上次生成ID的时间戳

    // 构造函数
    public SnowflakeId(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    // 生成ID
    public synchronized long nextId() {
        long timestamp = currentTimeMillis();

        // 如果当前时间小于上次生成ID的时间戳，说明系统时钟回退过，这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
        }

        // 如果是同一毫秒内生成的，则自增序列号
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            // 序列号溢出，当前毫秒内序列数超过4095
            if (sequence == 0) {
                // 阻塞到下一毫秒, 获得新的时间戳
                timestamp = tillNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L; // 如果是新的毫秒，则重置序列号
        }

        // 更新最近的时间戳
        lastTimestamp = timestamp;

        // 移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    // 阻塞到下一个毫秒，直到获得新的时间戳
    protected long tillNextMillis(long lastTimestamp) {
        long timestamp = currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = currentTimeMillis();
        }
        return timestamp;
    }

    // 获取当前的毫秒数
    protected long currentTimeMillis() {
        return System.currentTimeMillis();
    }

}

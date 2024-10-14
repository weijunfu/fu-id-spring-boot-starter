package com.ijunfu.id.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024-10-14 16:42
 * @Version: 1.0
 * @Motto : 世界很大 世界很小
 */
@Slf4j
class SnowflakeIdTest {

    @DisplayName("雪花算法")
    @Test
    void snowflakeId() {
        SnowflakeId snowflakeId = new SnowflakeId(1, 1);

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        IntStream.range(0, 100).forEach(i -> {
            log.info("{}", snowflakeId.nextId());
        });

        stopWatch.stop();

        log.info("totalTime={}ms", stopWatch.getTotalTimeMillis());
    }
}
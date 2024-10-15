package io.github.weijunfu.id.configuration;

import io.github.weijunfu.id.utils.SnowflakeId;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.stream.IntStream;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024-10-14 16:50
 * @Version: 1.0
 * @Motto : 世界很大 世界很小
 */
@Slf4j
@SpringBootTest
class SnowflakeConfigurationTest {

    @Autowired
    private SnowflakeId snowflakeId;

    @Test
    @DisplayName("雪花算法")
    void snowflakeId() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        IntStream.range(0,100).forEach(i -> {
            log.info("{}", snowflakeId.nextId());
        });

        stopWatch.stop();
        log.info("totalTime={}ms", stopWatch.getTotalTimeMillis());
    }
}
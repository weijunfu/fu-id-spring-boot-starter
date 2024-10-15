package io.github.weijunfu.id.configuration;


import io.github.weijunfu.id.utils.NanoId;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.stream.IntStream;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024-10-14 19:54
 * @Version: 1.0
 * @Motto : 世界很大 世界很小
 */
@Slf4j
@SpringBootTest
public class NanoConfigurationTest {

    @Resource
    private NanoId nanoId;

    @Test
    @DisplayName("Nano ID")
    void nextId() {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        IntStream.range(0,100).forEach(i -> {
            log.info("{}", nanoId.nextId());
        });
        stopWatch.stop();

        log.info("{}ms", stopWatch.getTotalTimeMillis());
    }
}

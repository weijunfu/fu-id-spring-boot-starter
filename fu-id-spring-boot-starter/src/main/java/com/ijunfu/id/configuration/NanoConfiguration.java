package com.ijunfu.id.configuration;


import com.ijunfu.id.property.NanoIdProperties;
import com.ijunfu.id.utils.NanoId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title : 雪花算法配置类
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024-10-14 16:47
 * @Version: 1.0
 * @Motto : 世界很大 世界很小
 */
@Configuration
@EnableConfigurationProperties(NanoIdProperties.class)
public class NanoConfiguration {

    private final NanoIdProperties nanoIdProperties;

    public NanoConfiguration(NanoIdProperties nanoIdProperties) {
        this.nanoIdProperties = nanoIdProperties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "fu.nano", name = "enabled", havingValue = "true")
    public NanoId nanoId() {
        return new NanoId(
                nanoIdProperties.getSize(),
                nanoIdProperties.getAlphabet().toCharArray()
        );
    }

}

package com.ijunfu.id.configuration;


import com.ijunfu.id.property.SnowflakeProperties;
import com.ijunfu.id.utils.SnowflakeId;
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
@EnableConfigurationProperties(SnowflakeProperties.class)
public class SnowflakeConfiguration {

    private final SnowflakeProperties snowflakeProperties;

    public SnowflakeConfiguration(SnowflakeProperties snowflakeProperties) {
        this.snowflakeProperties = snowflakeProperties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "fu.snowflake", name = "enabled", havingValue = "true")
    public SnowflakeId snowflakeId() {
        return new SnowflakeId(
                snowflakeProperties.getWorkerId(),
                snowflakeProperties.getDataCenterId()
        );
    }

}

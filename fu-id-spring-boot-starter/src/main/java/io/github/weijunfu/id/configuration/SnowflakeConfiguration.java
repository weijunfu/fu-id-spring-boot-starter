package io.github.weijunfu.id.configuration;


import io.github.weijunfu.id.property.SnowflakeProperties;
import io.github.weijunfu.id.utils.SnowflakeId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 雪花算法配置类
 * @author ijunfu
 * @version 1.0.0
 *
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

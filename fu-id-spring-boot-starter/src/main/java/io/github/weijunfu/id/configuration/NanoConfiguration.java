package io.github.weijunfu.id.configuration;


import io.github.weijunfu.id.property.NanoIdProperties;
import io.github.weijunfu.id.utils.NanoId;
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

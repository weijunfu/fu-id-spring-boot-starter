package io.github.weijunfu.id.configuration;

import io.github.weijunfu.id.property.HashidsProperties;
import io.github.weijunfu.id.utils.Hashids;
import io.github.weijunfu.id.utils.NanoId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ijunfu
 * @version 1.0.0
 *
 */
@Configuration
@EnableConfigurationProperties(HashidsProperties.class)
public class HashidsConfiguration {

    private HashidsProperties hashidsProperties;

    public HashidsConfiguration(HashidsProperties hashidsProperties) {
        this.hashidsProperties = hashidsProperties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "fu.hashids", name = "enabled", havingValue = "true")
    public Hashids hashids() {
        return new Hashids(
                hashidsProperties.getSalt(),
                hashidsProperties.getAlphabet(),
                hashidsProperties.getSize()
        );
    }
}

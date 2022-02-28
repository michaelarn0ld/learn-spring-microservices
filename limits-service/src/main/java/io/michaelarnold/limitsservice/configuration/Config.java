package io.michaelarnold.limitsservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("limits-service")
public class Config {
    private int minimum;
    private int maximum;
}

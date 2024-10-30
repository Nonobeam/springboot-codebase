package org.nonoproject.nonoproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebConfig.class, AppConfig.class, WebConfig.class})
public class InfrastructureConfig {
}

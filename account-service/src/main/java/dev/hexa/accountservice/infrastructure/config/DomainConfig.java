package dev.hexa.accountservice.infrastructure.config;

import dev.hexa.accountservice.application.annotation.DomainService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "dev.hexa.accountservice.application",
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION, classes = {DomainService.class}
                )
        })
public class DomainConfig {
}

package dev.hexa.customerservice.infrastructure.config;

import dev.hexa.customerservice.application.annotation.DomainService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "dev.hexa.customerservice.application",
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION, classes = {DomainService.class}
                )
        })
public class DomainConfig {
}

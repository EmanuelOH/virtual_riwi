package com.riwi.virtual_riwi.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Virtual Riwi",
        version = "1.0",
        description = "API to manage Virtual Riwi"
))
public class OpenApiConfiguration {
}

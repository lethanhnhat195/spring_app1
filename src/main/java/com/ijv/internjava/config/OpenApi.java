package com.ijv.internjava.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import java.util.List;

@Configuration
public class OpenApi {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Intership 9+ solution")
                        .description("Sample OpenAPI 3.0")
                        .termsOfService("https://virtserver.swaggerhub.com/BARKING18111999_1/Test/1.0.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                        .version("1.0.0")
                )
                .servers(List.of(new Server().url("http://localhost:8080"))); //add more Server
    }

    /**
     * custom jwt from header
     */
    @Component
    public static class GlobalHeaderOperationCustomizer implements OperationCustomizer {

        @Override
        public Operation customize(Operation operation, HandlerMethod handlerMethod) {
            Parameter token = new Parameter().in(ParameterIn.HEADER.toString()).name("Authorization")
                    .description("Bearer Token: Required").schema(new StringSchema()).required(false);
            operation.addParametersItem(token);
            return operation;
        }
    }
}

package com.csdj.springbootredis.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public GroupedOpenApi redisApi() {
        return GroupedOpenApi.builder()
                .group("redis")
                .pathsToMatch("/redis/**")
                .build();
    }

    @Bean
    public GroupedOpenApi accountApi() {
        return GroupedOpenApi.builder()
                .group("account")
                .pathsToMatch("/account/**")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring-redis API")
                        .description("Spring-redis")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Springdoc")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("接口文档")
                        .url("https://www.yuque.com/leifengyang/springboot3/bl6zm930hny1mm1l")
                );
    }
}

package com.example.restfulapi2.personapp.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Config {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(new Info().title("User API")
                        .description("User Application")
                        .version("v0.0.1"));
}

}


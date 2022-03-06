package com.example.Q6SpringFramework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanContext {

    @Bean
    Beta beta(){
        return new Beta();
    }
}

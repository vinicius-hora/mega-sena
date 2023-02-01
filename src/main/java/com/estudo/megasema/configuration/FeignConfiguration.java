package com.estudo.megasema.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Logger.Level feingLoggerLevel(){
        return Logger.Level.HEADERS;
    }


}

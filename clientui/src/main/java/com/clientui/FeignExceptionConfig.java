package com.clientui;

import com.clientui.exceptions.CustomeErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignExceptionConfig {

    @Bean
    public CustomeErrorDecoder myCommerceCustomErrorDecoder() {
        return new CustomeErrorDecoder() ;
    }

}

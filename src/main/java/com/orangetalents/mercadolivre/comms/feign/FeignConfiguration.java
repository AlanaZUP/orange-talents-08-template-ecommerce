package com.orangetalents.mercadolivre.comms.feign;

import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Bean
    public Client feignCliente() {
        return new Client.Default(null, null);
    }
}

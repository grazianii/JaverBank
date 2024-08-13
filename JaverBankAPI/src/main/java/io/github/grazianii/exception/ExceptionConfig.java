package io.github.grazianii.exception;

import feign.codec.ErrorDecoder;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@Configuration
public class ExceptionConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
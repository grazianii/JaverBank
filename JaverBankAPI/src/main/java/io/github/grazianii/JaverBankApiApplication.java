package io.github.grazianii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JaverBankApiApplication {

    public static void main (String[] args){

        SpringApplication.run(JaverBankApiApplication.class, args);
    }
}
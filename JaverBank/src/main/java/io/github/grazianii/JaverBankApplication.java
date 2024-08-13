package io.github.grazianii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JaverBankApplication {

    public static void main(String[] args){

        SpringApplication.run(JaverBankApplication.class, args);
    }
}

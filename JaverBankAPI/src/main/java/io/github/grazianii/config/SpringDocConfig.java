package io.github.grazianii.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
@NoArgsConstructor
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI (){
        return (new OpenAPI())
                .info((new Info())
                        .title("Javer Bank API")
                        .version("1.0")
                        .description("Documentação do microsserviço de operações CRUD no banco de dados")
                        .contact(contact()));
    }

    private Contact contact() {
        return new Contact()
                .name("Rodrigo Romaris")
                .url("https://github.com/grazianii/JaverBank")
                .email("rodrigo.romaris@ibm.com");
    }
}
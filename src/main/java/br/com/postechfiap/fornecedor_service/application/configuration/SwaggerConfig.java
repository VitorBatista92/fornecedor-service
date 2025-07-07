package br.com.postechfiap.fornecedor_service.application.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info()
                .title("API gerenciamento de Fornecedores - FIAP HACKATON")
                .version("v1")
                .description("Documentação da API de Fornecedores do sistema de Medicamentos do SUS.")
        );
    }
}

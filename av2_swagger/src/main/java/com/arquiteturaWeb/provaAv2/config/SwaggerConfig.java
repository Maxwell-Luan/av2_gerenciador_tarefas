package com.arquiteturaWeb.provaAv2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.ParameterBuilder;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.arquiteturaWeb.provaAv2.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(globalOperationParameters());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API de Tarefas")
                .description("Documentação da API de Tarefas com Spring Boot")
                .version("1.0.0")
                .build();
    }

    private List<Parameter> globalOperationParameters() {
        Parameter authorizationHeader = new ParameterBuilder()
                .name("Authorization") // Nome do cabeçalho
                .description("Token JWT de autenticação") // Descrição do cabeçalho
                .modelRef(new springfox.documentation.schema.ModelRef("string")) // Tipo do dado
                .parameterType("header") // Define que é um cabeçalho
                .required(false) // Não é obrigatório por padrão
                .build();

        return List.of(authorizationHeader); // Retorna o parâmetro para ser utilizado globalmente
    }
}

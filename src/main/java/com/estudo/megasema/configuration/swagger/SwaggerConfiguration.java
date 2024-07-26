package com.estudo.megasema.configuration.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {
    @Value("${config.openapi.dev-url}")
    private String devUrl;

    @Value("${config.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        //authorization and security token


        Components components = new Components();


        //servers
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        //contact
        Contact contact = new Contact();
        contact.setEmail("vinicius_hora@live.com");
        contact.setName("Vinicius");
        contact.setUrl("https://www.linkedin.com/in/vinicius-bastos-208ab7189/");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
        //info
        Info info = new Info()
                .title("Mega-sena Aplicação Backend")
                .version("1.0")
                .contact(contact)
                .description("Backend de uma aplicação para visualizar resultados e gerar numérios aleatórios de sorteio.").termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense);
//        passagem dos parametros de configuração
        return new OpenAPI()
                .components(components)
                .info(info).servers(List.of(devServer, prodServer));
    }
}

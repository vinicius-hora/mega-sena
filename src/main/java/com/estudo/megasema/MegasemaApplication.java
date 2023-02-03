package com.estudo.megasema;

import com.estudo.megasema.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
@EnableAsync
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
public class MegasemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegasemaApplication.class, args);
	}

}

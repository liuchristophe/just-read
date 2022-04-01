package com.csid.justread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;

/** http://localhost:8080/swagger-ui/ **/

@SpringBootApplication
@EnableSwagger2
public class JustReadApplication {

	public static void main(String[] args) {
		System.out.println(new File(".").getAbsolutePath());
		SpringApplication.run(JustReadApplication.class, args);
	}

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).select().apis((RequestHandlerSelectors.any())).paths(PathSelectors.any()).build();
	}
}

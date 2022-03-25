package com.csid.justread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

import java.io.File;

@SpringBootApplication
public class JustReadApplication {

	public static void main(String[] args) {
		System.out.println(new File(".").getAbsolutePath());
		SpringApplication.run(JustReadApplication.class, args);
	}

//	@Bean
//	public Docket api(){
//		return new Docket(DocumentationType.SWAGGER_2).select().apis((RequestHandlerSelectors.any())).paths(PathSelectors.any()).build();
//	}
}

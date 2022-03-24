package com.csid.justread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class JustReadApplication {

	public static void main(String[] args) {
		System.out.println(new File(".").getAbsolutePath());
		SpringApplication.run(JustReadApplication.class, args);
	}

}

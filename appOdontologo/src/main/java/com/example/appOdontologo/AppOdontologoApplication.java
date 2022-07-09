package com.example.appOdontologo;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppOdontologoApplication {

	public static void main(String[] args) {

		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		SpringApplication.run(AppOdontologoApplication.class, args);
	}

}

package com.familyApi.FamilyApiCleanCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class FamilyApiCleanCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyApiCleanCodeApplication.class, args);
	}

}

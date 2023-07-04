package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class KursApplication {

	public static void main(String[] args) {
		SpringApplication.run(KursApplication.class, args);
	}

	@Bean
	public Call call(){
		Call call = new Call();
		call.setName("Adam");
		return call;
	}

	@Bean(name = "callMichal")
	public Call call2(){
		Call call = new Call();
		call.setName("Michal");
		return call;
	}



}

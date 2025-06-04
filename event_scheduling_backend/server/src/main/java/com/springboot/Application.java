package com.springboot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.springboot.backend.controllers", "com.springboot.backend.entities", "com.springboot.backend.repositories", "com.springboot.backend.requests", "com.springboot.backend.resourceAssembler",
"com.springboot.backend.resources", "com.springboot.backend.services"})
@EnableJpaRepositories(basePackages = "com.springboot.backend.repositories")
@EntityScan(basePackages = "com.springboot.backend.entities")
@Slf4j
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
	
}

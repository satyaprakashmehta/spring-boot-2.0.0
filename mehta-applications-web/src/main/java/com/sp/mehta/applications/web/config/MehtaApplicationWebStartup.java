package com.sp.mehta.applications.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan (basePackages={"com.sp.mehta.applications"})
@EnableJpaRepositories(basePackages={"com.sp.mehta.applications.repository"})
@EntityScan(basePackages={"com.sp.mehta.applications.model"})
public class MehtaApplicationWebStartup {
	public static void main(String[] args) {
		SpringApplication.run(MehtaApplicationWebStartup.class, args);
	}
}

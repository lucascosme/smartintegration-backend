package com.lcsolution.smartIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.lcsolution.smartIntegration")
@EnableTransactionManagement
@SpringBootApplication
public class SmartIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartIntegrationApplication.class, args);
	}
}

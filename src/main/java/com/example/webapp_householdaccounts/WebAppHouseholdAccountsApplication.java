package com.example.webapp_householdaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.webapp_householdaccounts.repository")
@SpringBootApplication
public class WebAppHouseholdAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppHouseholdAccountsApplication.class, args);
	}

}

package com.example.customerservice.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;

/**
 * The CustomerServiceServerApplication class...
 *
 * @author John Blum
 * @since 1.0.0
 */
@SpringBootApplication
@CacheServerApplication(name = "CustomerServiceServer")
@EnableLocator
@EnableManager
public class CustomerServiceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceServerApplication.class, args);
	}
}

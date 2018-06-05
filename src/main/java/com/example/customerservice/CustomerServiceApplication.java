package com.example.customerservice;

import com.example.customerservice.domain.Customer;
import com.example.customerservice.repo.CustomerRepository;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;

@SpringBootApplication
@EnableEntityDefinedRegions(basePackageClasses = Customer.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner run(CustomerRepository customerRepository) {

		return args -> {

			customerRepository.save(new Customer("foo"));
			customerRepository.save(new Customer("bar"));

			System.out.println("Customers are: "+customerRepository.findAll());
		};
	}
}

package com.example.customerservice.client;

import com.example.customerservice.client.config.CustomMappingPdxSerializerConfiguration;
import com.example.customerservice.client.domain.Customer;
import com.example.customerservice.client.repo.CustomerRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.geode.config.annotation.UseMemberName;

@SpringBootApplication
@EnableClusterConfiguration
@EnableEntityDefinedRegions(basePackageClasses = Customer.class)
@UseMemberName("CustomerServiceClientApplication")
@Import(CustomMappingPdxSerializerConfiguration.class)
public class CustomerServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceClientApplication.class, args);
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

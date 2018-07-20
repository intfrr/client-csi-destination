package bx.cps.cross_domain.persistence.gemfire.config;

import bx.cps.cross_domain.persistence.gemfire.config.properties.CustomerServiceClientApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class CustomerServiceClientApplicationConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	CustomerServiceClientApplicationProperties customerServiceClientApplicationProperties() {
		CustomerServiceClientApplicationProperties bean = new CustomerServiceClientApplicationProperties();
		
		bean.setMember_application_name(environment.getProperty("csi-destination.member.application.name"));
		
		return bean;
	}
}

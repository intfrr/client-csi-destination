package bx.cps.cross_domain.persistence.gemfire;

import bx.cps.cross_domain.persistence.gemfire.domain.Customer;
import bx.cps.cross_domain.persistence.gemfire.config.CustomMappingPdxSerializerConfiguration;
import bx.cps.cross_domain.persistence.gemfire.repo.CustomerRepository;

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
//@EnableEntityDefinedRegions(basePackageClasses = Customer.class)
/*@EnableEntityDefinedRegions(
	basePackages = Array("bx.cps.cross_domain.persistence.gemfire.domain"),
	useDefaultFilters = false,
	includeFilters = Array(
		new ComponentScan.Filter(`type` = FilterType.ASSIGNABLE_TYPE,
		value = Array(classOf[bx.cps.cross_domain.persistence.gemfire.domain]))))
)*/
//@EnableEntityDefinedRegions(basePackageClasses = Array("bx.cps.cross_domain.persistence.gemfire.domain"))
@EnableEntityDefinedRegions("bx.cps.cross_domain.persistence.gemfire.domain")
@UseMemberName("CustomerServiceClientApplication")
//@UseMemberName(${csi-destination.member.application.name})
@Import(CustomMappingPdxSerializerConfiguration.class)
public class CustomerServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceClientApplication.class, args);
	}

	@Bean
	ApplicationRunner run(CustomerRepository customerRepository) {

		return args -> {

			Customer C112888227 = new Customer(112888227L, 4L, "León", "Alfonso Nápoles Gándara 1117, Santa Fe, Zedec Sta Fé", "Mexico City", "01219");
			Customer C112888228 = new Customer(112888228L, 4L, "León", "Alfonso Nápoles Gándara 1117, Santa Fe, Zedec Sta Fé", "Mexico City", "01219");
			
			customerRepository.save(C112888227);
			customerRepository.save(C112888228);

			System.out.println("Customers are: "+customerRepository.findAll());
			
			if(customerRepository.existsById(112888227L)) {
				System.out.println("Customer  112888227L exists");
			}
			
			
			if(!customerRepository.existsById(112888229L)) {
				System.out.println("Customer 112888229L does not exist");
			}
			
		};
	}
}

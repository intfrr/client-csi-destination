package com.example.customerservice.client.config;

import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.ClientCacheConfigurer;
import org.springframework.data.gemfire.mapping.MappingPdxSerializer;

/**
 * The CustomMappingPdxSerializerConfiguration class...
 *
 * @author John Blum
 * @since 1.0.0
 */
@Configuration
@SuppressWarnings("all")
public class CustomMappingPdxSerializerConfiguration {

	// TODO: remove ClientCacheConfigurer bean definition to register custom MappingPdxSerializer
	// with SDG 2.0.8.RELEASE or 2.1.0.RC1.
	@Bean
	ClientCacheConfigurer clientCachePdxSerializerConfigurer() {
		return (beanName, clientCacheFactoryBean) -> clientCacheFactoryBean.setPdxSerializer(customMappingPdxSerializer());
	}

	// TODO: remove custom MappingPdxSerializer bean definition with SDG 2.0.8.RELEASE or 2.1.0.RC1.
	//@Bean
	MappingPdxSerializer customMappingPdxSerializer() {

		Predicate<Class<?>> excludeTypeFilters = type -> !type.getPackage().getName().startsWith("java");

		excludeTypeFilters = excludeTypeFilters.and(type ->
			!type.getPackage().getName().startsWith("org.springframework"));

		MappingPdxSerializer mappingPdxSerializer = MappingPdxSerializer.newMappingPdxSerializer();

		mappingPdxSerializer.setTypeFilters(excludeTypeFilters);

		return mappingPdxSerializer;
	}
}

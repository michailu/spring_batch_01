package br.com.michailu.spring_batch_01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

/**
 * Usado para externalizar configurações, precisa apontar para um application.properties
 */
@Configuration
public class PropertiesConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer config() {
		PropertySourcesPlaceholderConfigurer configure = new PropertySourcesPlaceholderConfigurer();
		configure.setLocation(new FileSystemResource("D:\\luciano.michailu\\workspace_spring_tool_suite\\spring_batch_01\\application.properties"));
		return configure;
	}
}
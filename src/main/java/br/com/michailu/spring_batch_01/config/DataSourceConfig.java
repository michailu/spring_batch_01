package br.com.michailu.spring_batch_01.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DataSourceConfig {

	/**
	 * Banco para uso do spring batch
	 */
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource springDataSource() {
		return DataSourceBuilder
				.create()
				.build();
	}

	@Bean
	@ConfigurationProperties(prefix = "beneficios.datasource")
	public DataSource beneficiosDatasource() {
		return DataSourceBuilder
				.create()
				.build();
	}

	/**
	 * Necessario para que exista controle transacional no data source secundario
	 */
	@Bean
	public PlatformTransactionManager controleTransacaoBancoApp(
			@Qualifier("beneficiosDatasource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
package br.com.michailu.spring_batch_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * application.properties externalizado
 * dois bancos de dados configurados, um para o spring batch e outro para aplicacao (com controle transacional manual)
 * utiliza log4j
 * disponivel no github
 * writer pega do banco de dados, processor transforma e writer persiste no banco de dados
 */
@SpringBootApplication
public class SpringBatch01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatch01Application.class, args);
	}
}
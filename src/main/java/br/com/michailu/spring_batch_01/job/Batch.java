package br.com.michailu.spring_batch_01.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import br.com.michailu.spring_batch_01.modelo.Auxilio;
import br.com.michailu.spring_batch_01.modelo.Dap;
import br.com.michailu.spring_batch_01.processor.DapRowMapper;
import br.com.michailu.spring_batch_01.processor.Processor;
import br.com.michailu.spring_batch_01.tasklet.LimparTabelaAuxiliosTasklet;

@Configuration
@EnableBatchProcessing
public class Batch {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
    private StepBuilderFactory stepBuilderFactory;

	@Autowired
	@Qualifier("beneficiosDatasource")
	private DataSource dataSource;

	/**
	 * Controle de transacao para o banco de dados secundario
	 * O controleTransacaoBancoApp mencionado no qualifier precisa
	 * ter a mesma descricao do metodo em DataSourceConfig.java
	 */
	@Autowired
	@Qualifier("controleTransacaoBancoApp")
	private PlatformTransactionManager controleTransacao;

	@Autowired
	LimparTabelaAuxiliosTasklet limparTabelaAuxiliosTasklet;

	@Bean
	public Job springBatch01() {
		return jobBuilderFactory
				.get("springBatch01")
				.incrementer(new RunIdIncrementer())
				.start(stepLimpezaTabela())
				.next(stepProcessamento())
				.build();
	}

	@Bean
	public Step stepLimpezaTabela() {
		return stepBuilderFactory
				.get("processamento limpeza da tabela auxilios")
				.tasklet(limparTabelaAuxiliosTasklet)
				.build();
	}

	@Bean
	public Step stepProcessamento() {
		return stepBuilderFactory
				.get("processamento batch 01")
				.<Dap, Auxilio>chunk(5)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.transactionManager(controleTransacao)
				.build();
	}

	@Bean
	public JdbcCursorItemReader<Dap> reader() {
		return new JdbcCursorItemReaderBuilder<Dap>()
				.dataSource(this.dataSource)
				.name("dapReader")
				.sql("SELECT cpf, nome, mae, dn, nis, dap, dt_validade_dap from daps")
				.rowMapper(new DapRowMapper())
				.build();
	}

	@Bean
	public ItemProcessor<Dap, Auxilio> processor() {
		return new Processor();
	}

	@Bean
	public ItemWriter<Auxilio> writer() {
		return new JdbcBatchItemWriterBuilder<Auxilio>()
		.dataSource(this.dataSource)
		.sql("INSERT INTO AUXILIOS (cpf, nome, mae, nascimento, nis, cod_fam_cadunico, tipo, situacao, dt_inicio, dt_fim) VALUES (:cpf, :nome, :mae, :nascimento, :nis, :cod_fam_cadunico, :tipo, :situacao, :inicio, :fim)")
		.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
		.build();
	}
}
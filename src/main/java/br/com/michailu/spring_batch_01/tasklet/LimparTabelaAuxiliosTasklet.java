package br.com.michailu.spring_batch_01.tasklet;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class LimparTabelaAuxiliosTasklet extends JdbcDaoSupport implements Tasklet {

	@Autowired
	public LimparTabelaAuxiliosTasklet(@Qualifier("beneficiosDatasource") DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		getJdbcTemplate().update("DELETE FROM AUXILIOS");
		return RepeatStatus.FINISHED;
	}
}
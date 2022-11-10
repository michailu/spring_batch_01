package br.com.michailu.spring_batch_01.processor;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;

import br.com.michailu.spring_batch_01.modelo.Auxilio;
import br.com.michailu.spring_batch_01.modelo.Dap;

public class Processor implements ItemProcessor<Dap, Auxilio> {

	@Override
	public Auxilio process(Dap item) throws Exception {
		if (item.getCpf().equals("0") || item.getCpf() == null || item.getCpf().equals("")) {
			return null;
		}
		Auxilio auxilio = new Auxilio();
		auxilio.setCpf(item.getCpf());
		auxilio.setNis(item.getNis()); // Buscar no CNIS
		String nomeSemCaracteres = item.getNome().replace(".", "").replace("/", "");
		auxilio.setNome(nomeSemCaracteres.toUpperCase()); // Buscar no CNIS
		auxilio.setMae(item.getMae().toUpperCase()); // Buscar no CNIS
		auxilio.setCod_fam_cadunico("123456"); // Buscar no Cadunico
		auxilio.setTipo(0); // 0 AIPR
		auxilio.setSituacao(0); // 0 Ativo
		Date date = new Date();
		Timestamp dataAtual = new Timestamp(date.getTime());
		auxilio.setNascimento(dataAtual); // Buscar no CNIS
		auxilio.setInicio(dataAtual);
		auxilio.setFim(dataAtual);
		return auxilio;
	}
}
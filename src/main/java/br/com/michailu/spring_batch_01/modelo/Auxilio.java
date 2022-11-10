package br.com.michailu.spring_batch_01.modelo;

import java.sql.Timestamp;

public class Auxilio {
	private String cpf;
	private String nome;
	private String mae;
	private Timestamp nascimento;
	private String nis;
	private String cod_fam_cadunico;
	private int tipo;
	private int situacao;
	private Timestamp inicio;
	private Timestamp fim;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public Timestamp getNascimento() {
		return nascimento;
	}

	public void setNascimento(Timestamp nascimento) {
		this.nascimento = nascimento;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getCod_fam_cadunico() {
		return cod_fam_cadunico;
	}

	public void setCod_fam_cadunico(String cod_fam_cadunico) {
		this.cod_fam_cadunico = cod_fam_cadunico;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public Timestamp getInicio() {
		return inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public Timestamp getFim() {
		return fim;
	}

	public void setFim(Timestamp fim) {
		this.fim = fim;
	}
}
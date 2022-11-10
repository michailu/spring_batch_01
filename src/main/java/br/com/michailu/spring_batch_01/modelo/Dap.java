package br.com.michailu.spring_batch_01.modelo;

public class Dap {
	private String cpf;
	private String nome;
	private String mae;
	private String dn;
	private String nis;
	private String dap;
	private String dt_validade_dap;

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

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getDap() {
		return dap;
	}

	public void setDap(String dap) {
		this.dap = dap;
	}

	public String getDt_validade_dap() {
		return dt_validade_dap;
	}

	public void setDt_validade_dap(String dt_validade_dap) {
		this.dt_validade_dap = dt_validade_dap;
	}
}
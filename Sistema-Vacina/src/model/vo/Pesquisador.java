package model.vo;

import java.util.Date;

public class Pesquisador {
	
	private int id;
	private String nome;
	private String cpf;
	private String instituicao;
	private Date dataNascimento;
	private char sexo;
	
	

	

	public Pesquisador(int id, String nome, String cpf, String instituicao, Date dataNascimento, char sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.instituicao = instituicao;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	public Pesquisador() {
		super();

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Pesquisador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", instituicao=" + instituicao
				+ ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + "]";
	}

	

}

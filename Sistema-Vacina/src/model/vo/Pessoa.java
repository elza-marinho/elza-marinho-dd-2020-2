package model.vo;

import java.util.Date;

public class Pessoa {
	private int id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private char sexo;
	private boolean voluntario;

	public Pessoa() {
		super();

	}

	public Pessoa(int id, String nome, String cpf, Date dataNascimento, char sexo, boolean voluntario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.voluntario = voluntario;
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

	public boolean isVoluntario() {
		return voluntario;
	}

	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", sexo="
				+ sexo + ", voluntario=" + voluntario + "]";
	}
	
	

}

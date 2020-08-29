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

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", sexo="
				+ sexo + ", voluntario=" + voluntario + "]";
	}
	
	

}

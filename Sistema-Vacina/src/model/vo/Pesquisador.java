package model.vo;

import java.util.Date;

public class Pesquisador {
private String nome;
private String cpf;
private String instituicao;
private Date dataNascimento;
private char sexo;

public Pesquisador() {
	super();
	
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
	return "Pesquisador [nome=" + nome + ", cpf=" + cpf + ", instituicao=" + instituicao + ", dataNascimento="
			+ dataNascimento + ", sexo=" + sexo + "]";
}


	
}

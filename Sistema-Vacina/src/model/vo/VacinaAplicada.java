package model.vo;

import java.util.Date;

public class VacinaAplicada {
	
	private int id;
	private int idPessoa;
	private int idPesquisador;
	private int idVacina;
	private Date dataAplicacao;
	private int notaVacina;
	
	
	public VacinaAplicada() {
		super();
		
	}


	public VacinaAplicada(int id, int idPessoa, int idPesquisador, int idVacina, Date dataAplicacao, int nota) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.idPesquisador = idPesquisador;
		this.idVacina = idVacina;
		this.dataAplicacao = dataAplicacao;
		this.notaVacina = nota;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdPessoa() {
		return idPessoa;
	}


	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}


	public int getIdPesquisador() {
		return idPesquisador;
	}


	public void setIdPesquisador(int idPesquisador) {
		this.idPesquisador = idPesquisador;
	}


	public int getIdVacina() {
		return idVacina;
	}


	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
	}


	public Date getDataAplicacao() {
		return dataAplicacao;
	}


	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}


	public int getNota() {
		return notaVacina;
	}


	public void setNota(int nota) {
		this.notaVacina = nota;
	}


	@Override
	public String toString() {
		return "VacinaAplicada [id=" + id + ", idPessoa=" + idPessoa + ", idPesquisador=" + idPesquisador
				+ ", idVacina=" + idVacina + ", dataAplicacao=" + dataAplicacao + ", nota=" + notaVacina + "]";
	}
	
	
	
			

}

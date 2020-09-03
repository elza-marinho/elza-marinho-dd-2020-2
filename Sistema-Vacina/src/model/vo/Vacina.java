package model.vo;

import java.util.Date;

public class Vacina {
	private int id;
	private String paisOrigem;
	private Date dataInicio;
	private int estagioPesquisa;
	private String NomePesquisador;

	public Vacina() {
		super();

	}
	

	public Vacina(int id, String paisOrigem, Date dataInicio, int estagioPesquisa, String nomePesquisador) {
		super();
		this.id = id;
		this.paisOrigem = paisOrigem;
		this.dataInicio = dataInicio;
		this.estagioPesquisa = estagioPesquisa;
		NomePesquisador = nomePesquisador;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public int getEstagioPesquisa() {
		return estagioPesquisa;
	}

	public void setEstagioPesquisa(int estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}

	public String getNomePesquisador() {
		return NomePesquisador;
	}

	public void setNomePesquisador(String nomePesquisador) {
		NomePesquisador = nomePesquisador;
	}


	@Override
	public String toString() {
		return "Vacina [id=" + id + ", paisOrigem=" + paisOrigem + ", dataInicio=" + dataInicio + ", estagioPesquisa="
				+ estagioPesquisa + ", NomePesquisador=" + NomePesquisador + "]";
	}

	
	
}

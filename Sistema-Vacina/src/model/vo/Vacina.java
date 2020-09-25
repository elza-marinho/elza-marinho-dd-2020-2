package model.vo;

import java.util.Date;

public class Vacina {

	public static final int ESTAGIO_INICIAL = 1;
	public static final int ESTAGIO_TESTES = 2;
	public static final int ESTAGIO_APLICACAO_NO_PUBLICO = 3;

	private int id;
	private String paisOrigem;
	private Date dataInicio;
	private int estagioPesquisa;
	private String NomePesquisador;

	public Vacina() {
		super();

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
		return "Vacina [id=" + id + ", paisOrigem=" + paisOrigem + ", dataInicio=" + dataInicio + ", NomePesquisador="
				+ NomePesquisador + "]";
	}

}

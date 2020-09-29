package model.vo;

import java.util.Date;

public class Vacina {

	public static final int ESTAGIO_INICIAL = 1;
	public static final int ESTAGIO_TESTES = 2;
	public static final int ESTAGIO_APLICACAO_NO_PUBLICO = 3;

	private int id;
	private String paisOrigem;
	private Date dataInicio;
	private int estagioVacina;
	private String NomePesquisador;

	public Vacina() {
		super();

	}

	public Vacina(int id, String paisOrigem, Date dataInicio, int estagioVacina, String nomePesquisador) {
		super();
		this.id = id;
		this.paisOrigem = paisOrigem;
		this.dataInicio = dataInicio;
		this.estagioVacina = estagioVacina;
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
	

	

	public int getEstagioVacina() {
		return estagioVacina;
	}

	public void setEstagioVacina(int estagioVacina) {
		this.estagioVacina = estagioVacina;
	}

	public String getNomePesquisador() {
		return NomePesquisador;
	}

	public void setNomePesquisador(String nomePesquisador) {
		NomePesquisador = nomePesquisador;
	}

	@Override
	public String toString() {
		return "Vacina [id=" + id + ", paisOrigem=" + paisOrigem + ", dataInicio=" + dataInicio + ", estagioVacina="
				+ estagioVacina + ", NomePesquisador=" + NomePesquisador + "]";
	}

		

}

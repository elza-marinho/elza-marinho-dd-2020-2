package model.vo;

import java.util.Date;

public class Vacina {
	private int id;
private String paisOrigem;
 private Date dataInicio;
 private int estagioPesquisa;
 private int idPesquisador;
 
public Vacina() {
	super();
	// TODO Auto-generated constructor stub
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

public int getIdPesquisador() {
	return idPesquisador;
}

public void setIdPesquisador(int idPesquisador) {
	this.idPesquisador = idPesquisador;
}

@Override
public String toString() {
	return "Vacina [id=" + id + ", paisOrigem=" + paisOrigem + ", dataInicio=" + dataInicio + ", estagioPesquisa="
			+ estagioPesquisa + ", idPesquisador=" + idPesquisador + "]";
}


}


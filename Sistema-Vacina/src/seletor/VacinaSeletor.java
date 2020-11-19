package seletor;

public class VacinaSeletor {
	
	private int id;
	private String nome;
	private String paisOrigem;
	
	private int limite;
	private int pagina;
	
	
	public VacinaSeletor() {
		super();
		this.limite = 0;
		this.pagina = -1;
		
	}
	
	public boolean temFiltro() {
		if(this.id>0) {
			return true;
		}
		
		if((this.nome!=null) && (this.nome.trim().length()>0)) {
			return true;
		}
		
		if((this.paisOrigem!=null) && (this.paisOrigem.trim().length()>0)){
			return true;
		}
		return false;
		
	}
	
	public boolean temPaginacao() {
		return ((this.limite > 0) && (this.pagina > -1));
	}
	
	public int getOffset() {
		return (this.limite * (this.pagina - 1));
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

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	

}

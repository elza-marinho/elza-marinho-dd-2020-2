package controller;

import model.bo.VacinaBO;
import model.dao.VacinaDao;
import model.vo.Vacina;

public class VacinaController {
	VacinaDao vdao = new VacinaDao();
	VacinaBO vbo = new VacinaBO();

	public String validarCamposTexto(String textPaisOrigem, String textPesquisador) {
		Vacina vacina = new Vacina();
		String mensagem = "";
		vacina.getNomePesquisador();
		vacina.getPaisOrigem();
		mensagem += validar(vacina);
		if (mensagem.isEmpty()) {
			vacina = vbo.cadastrarVacina(vacina);

		}
		return mensagem;
	}

	private String validar(Vacina vacina) {
		
		return null;
	}
	public String excluir(String textoIdSelecionado) {
		String mensagem = "";
		try {
			int idSelecionado = Integer.parseInt(textoIdSelecionado);
			mensagem = vbo.excluirPorId(idSelecionado);
		} catch (NumberFormatException ex) {
			mensagem = "Informe um número inteiro";
		}
		return mensagem;
	}

}

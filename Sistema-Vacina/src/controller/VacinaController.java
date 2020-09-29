package controller;

import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.bo.VacinaBO;
import model.dao.VacinaDao;
import model.vo.Vacina;

public class VacinaController {
	VacinaDao vdao = new VacinaDao();
	VacinaBO vbo = new VacinaBO();

	public String validarCamposTexto(String PaisOrigem, String Pesquisador) {
		Vacina vacina = new Vacina();
		String mensagem = "";
		if ((PaisOrigem == null) || (PaisOrigem.trim().length() < 3) || (PaisOrigem.trim().length() < 101)) {
			JOptionPane.showMessageDialog(null, "Campo país precisa conter no mínimo 3 caracteres");

		}
		if ((Pesquisador == null) || (Pesquisador.trim().length() < 3) || (Pesquisador.trim().length() < 101)) {
			JOptionPane.showMessageDialog(null, "Pesquisador precisa conter no mínimo 3 caracteres");
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

	public String salvarVacina() {
	
		String mensagem = "";
		Vacina vacina = new Vacina();
		vacina.getPaisOrigem();
		vacina.getNomePesquisador();
		vacina.getDataInicio();
		vacina.getEstagioVacina();
		return mensagem;
		
	
	}
}


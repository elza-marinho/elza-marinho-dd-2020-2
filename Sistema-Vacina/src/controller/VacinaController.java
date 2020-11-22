package controller;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.bo.VacinaBO;
import model.dao.VacinaDao;
import model.vo.Pesquisador;
import model.vo.Vacina;
import seletor.VacinaSeletor;

public class VacinaController {
	VacinaDao vdao = new VacinaDao();
	VacinaBO vbo = new VacinaBO();

	public String validar(String textPais,  JComboBox cbPesquisador , JComboBox cbEstagioPesquisa,
			String textDataInicio, String textNome) {
		String mensagem = "";
		if ((textPais == null) || (textPais.trim().length() < 3) || (textPais.trim().length() < 100)) {
			mensagem +="O país de origem precisa ter no mínimo 2 letras";

		}

		if ((cbPesquisador.getSelectedItem() ==null)) {
			mensagem += "Selecione um pesquisador!";
		}

		if ((cbEstagioPesquisa.getSelectedItem() != null) && !cbEstagioPesquisa.toString().equals("")) {
			mensagem += "Escolha o estágio em que a vacina se encontra!";
		}

		if (textDataInicio == null) {
			mensagem += "Digite uma data";
		}

		if ((textNome == null) || (textNome.trim().length() < 3) || (textNome.trim().length() < 256)) {
			mensagem += "Nome precisa ter no mínimo 3 caracteres";
		}
		return mensagem;

	}

	public ArrayList<Vacina> listarComSeletor(VacinaSeletor seletor) {

		return vbo.listarComSeletor(seletor);
	}

	public ArrayList<Vacina> listarTodos() {
		return vbo.listarTodos();

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

	public String validar(JTextField textPais, JComboBox cbPesquisador, JComboBox cbEstagioPesquisa,
			JFormattedTextField textDataInicio, JTextField textNome) {
				return null;
		// TODO Auto-generated method stub
		
	}

}

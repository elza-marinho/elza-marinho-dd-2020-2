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

	public void validar(JComboBox cbPais, Pesquisador pesquisadorSelecionado, JComboBox cbEstagioPesquisa,
			String textDataInicio, String textNome) {
		String mensagem = "";
		if (cbPais.getSelectedItem() != null && !cbPais.getSelectedItem().toString().equals("SELECIONE")) {
			JOptionPane.showMessageDialog(null, "Selecione um pa�s");

		}

		if ((pesquisadorSelecionado == null)) {
			JOptionPane.showMessageDialog(null, "Selecione um pesquisador!");
		}

		if ((cbEstagioPesquisa.getSelectedItem() != null) && !cbEstagioPesquisa.toString().equals("")) {
			JOptionPane.showMessageDialog(null, "Escolha o est�gio em que a vacina se encontra!");
		}

		if (textDataInicio == null) {
			JOptionPane.showMessageDialog(null, "Digite uma data");
		}

		if ((textNome == null) || (textNome.trim().length() < 3) || (textNome.trim().length() < 256)) {
			JOptionPane.showMessageDialog(null, "Nome precisa ter no m�nimo 3 caracteres");
		}

	}

	public ArrayList<Vacina> listarComSeletor(VacinaSeletor seletor) {

		return vbo.listarComSeletor(seletor);
	}
	public ArrayList<Vacina> listarTodos(){
		return vbo.listarTodos();
		
	}

	public String excluir(String textoIdSelecionado) {
		String mensagem = "";
		try {
			int idSelecionado = Integer.parseInt(textoIdSelecionado);
			mensagem = vbo.excluirPorId(idSelecionado);
		} catch (NumberFormatException ex) {
			mensagem = "Informe um n�mero inteiro";
		}
		return mensagem;
	}

}

package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.bo.VacinaBO;
import model.dao.PesquisadorDao;
import model.dao.VacinaDao;
import model.vo.Pesquisador;
import model.vo.Vacina;
import seletor.VacinaSeletor;

public class VacinaController {
	VacinaDao vdao = new VacinaDao();
	VacinaBO vbo = new VacinaBO();

	public String salvar(JTextField textPais,  JComboBox cbPesquisador , JComboBox cbEstagioPesquisa,
			JFormattedTextField textDataInicio, JTextField textNome) {
		String mensagem = "";
		if (textPais == null)  {
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

		if (textNome == null) {
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

	
		
		
	
	
	
	public void obterPesquisador() {
		PesquisadorDao dao = new PesquisadorDao();
		List<Pesquisador>pesquisadores = dao.listarTodos();
		
		
		
	}
	
	public void gerarRelatorio(List<Vacina> vacinas, String caminhoEscolhido) {
	
		
	}
		
	}



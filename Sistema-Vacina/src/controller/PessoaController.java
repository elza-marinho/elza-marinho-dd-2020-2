package controller;

import javax.swing.JOptionPane;

import model.bo.PessoaBO;
import model.dao.PessoaDao;
import model.vo.Pessoa;

public class PessoaController {
	PessoaDao peDao = new PessoaDao();
	PessoaBO pessoaBo = new PessoaBO();
	
	
	public String validarCamposTexto(String Nome, String Cpf) {
		Pessoa pessoa = new Pessoa();
		String mensagem = "";
		if ((Nome == null) || (Nome.trim().length() < 3) || (Nome.trim().length() < 101)) {
			JOptionPane.showMessageDialog(null, "Nome precisa ter no m�nimo 3 caracteres");

		}
		if ((Cpf == null) || (Cpf.trim().length() != 11)) {
			JOptionPane.showMessageDialog(null, "CPF cont�m somente 11 n�meros");

		}

		return mensagem;
	}

	private String validar(Pessoa pessoa) {
		
		return null;
	}

	
	
	public String cpfExistente(String txtCpf) {
		String mensagem = "";
		PessoaBO pessoa = new PessoaBO();
		if (pessoa.existeCpf(txtCpf)) {
			mensagem += "Este cpf j� est� sendo utilizado.\n";
		}
		return mensagem;
	}
	
	public String validarCpf(String txtCpf) {
		String mensagem = "";

		if (txtCpf.length() != 11) {
			mensagem += "O cpf deve possuir 11 d�gitos.\n";
		}
		if (txtCpf.isEmpty()) {
			mensagem += "O campo do cpf n�o foi preenchido.\n";
		}

		return mensagem;
	}
	
	public String excluir(String textoIdSelecionado) {
		String mensagem = "";
		try {
			int idSelecionado = Integer.parseInt(textoIdSelecionado);
			mensagem = pessoaBo.excluirPorId(idSelecionado);
		} catch (NumberFormatException ex) {
			mensagem = "Informe um n�mero inteiro";
		}
		return mensagem;
	}

}

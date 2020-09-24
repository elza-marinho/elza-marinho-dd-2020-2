package controller;

import java.util.List;

import model.bo.PesquisadorBO;
import model.dao.PesquisadorDao;
import model.vo.Pesquisador;

public class PesquisadorController {
	PesquisadorDao pdao = new PesquisadorDao();
	PesquisadorBO bo = new PesquisadorBO();

	public String excluir(String textoIdSelecionado) {
		String mensagem = "";
		try {
			int idSelecionado = Integer.parseInt(textoIdSelecionado);
			mensagem = bo.excluirPorId(idSelecionado);
		} catch (NumberFormatException ex) {
			mensagem = "Informe um número inteiro";
		}
		return mensagem;
	}

	public String validarCamposEscritos(String textnome, String textCpf, String textInstituicao) {
		Pesquisador pesquisador = new Pesquisador();
		String mensagem = "";
		pesquisador.setNome(textnome);
		pesquisador.setCpf(textCpf);
		pesquisador.setInstituicao(textInstituicao);

		mensagem += validar(pesquisador);
		if (mensagem.trim().isEmpty()) {
			pesquisador = bo.cadastrarPesquisador(pesquisador);
		}

		return mensagem;
	}

	public String cpfExistente(String txtCpf) {
		String mensagem = "";
		PesquisadorBO pesquisador = new PesquisadorBO();
		if (pesquisador.existeCpf(txtCpf)) {
			mensagem += "Este cpf já está sendo utilizado.\n";
		}
		return mensagem;
	}

	public String validarCpf(String txtCpf) {
		String mensagem = "";

		if (txtCpf.length() != 11) {
			mensagem += "O cpf deve possuir 11 dígitos.\n";
		}
		if (txtCpf.isEmpty()) {
			mensagem += "O campo do cpf não foi preenchido.\n";
		}

		return mensagem;
	}

	public List<Pesquisador> listarTodosOsPesquisadores() {
		return bo.listarTodos();
	}

	private String validar(Pesquisador pesquisador) {
		
		return null;
	}

}

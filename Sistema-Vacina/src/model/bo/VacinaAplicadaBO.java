package model.bo;

import java.util.ArrayList;

import model.dao.VacinaAplicadaDao;
import model.vo.VacinaAplicada;

public class VacinaAplicadaBO {

	VacinaAplicadaDao vacinacao = new VacinaAplicadaDao();

	public VacinaAplicada salvar(VacinaAplicada vacinacao) {
		VacinaAplicadaDao vacinacaoDao = new VacinaAplicadaDao();
		return vacinacaoDao.salvar(vacinacao);
	}

	public ArrayList<VacinaAplicada> listarTodos() {
		ArrayList<VacinaAplicada> vacinacao = listarTodos();
		return vacinacao;

	}

	public String excluirPorId(int idSelecionado) {
		String mensagem = "";
		VacinaAplicadaDao vacinacao = new VacinaAplicadaDao();
		if (vacinacao.excluir(idSelecionado)) {
			mensagem += "Vacinação excluída com sucesso";

		} else {
			mensagem += "Não foi possível excluir a vacinação";
		}
		return mensagem;
	}

}

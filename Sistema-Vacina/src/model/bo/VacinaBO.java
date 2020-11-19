package model.bo;

import java.util.ArrayList;

import model.dao.VacinaDao;
import model.vo.Vacina;
import seletor.VacinaSeletor;

public class VacinaBO {

	VacinaDao vacinaDao = new VacinaDao();

	public Vacina cadastrarVacina(Vacina vacina) {
		VacinaDao vacinaDao = new VacinaDao();
		return vacinaDao.cadastrar(vacina);
	}

	public ArrayList<Vacina> listarTodos() {
		ArrayList<Vacina> vacinas = vacinaDao.listarTodos();

		return vacinas;
	}

	public ArrayList<Vacina> listarComSeletor(VacinaSeletor seletor) {
		return vacinaDao.listarComSeletor(seletor);

	}

	public Vacina procurarVacinaPorId(String textId) {
		Vacina vacinaProcurada = vacinaDao.consultarPorId(Integer.parseInt(textId));
		return vacinaProcurada;

	}

	

	public String excluirPorId(int idSelecionado) {
		String mensagem = "";
		VacinaDao vacinaDao = new VacinaDao();
		if (vacinaDao.excluir(idSelecionado)) {
			mensagem = "Excluído com sucesso";
		} else {
			mensagem = "Erro ao excluir";
		}
		return mensagem;

	}

}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import model.vo.Pessoa;
import model.vo.Vacina;
import model.vo.VacinaAplicada;

public class VacinaAplicadaDao {

	public VacinaAplicada salvar(VacinaAplicada vacinacao) {
		Connection conn = Banco.getConnection();

		String sql = "INSERT INTO VACINAAPLICADA (IDVACINA, IDPACIENTE,DATAAPLICACAO, PAISORIGEM, NOTAVACINA, DOSE"
				+ " VALUES (?, ?, ?, ?, ?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		try {
			stmt.setInt(1, vacinacao.getVacina().getId());
			stmt.setInt(2, vacinacao.getPaciente().getId());
			stmt.setDate(3, (Date) vacinacao.getDataAplicacao());
			stmt.setString(4, vacinacao.getPaisOrigem());
			stmt.setInt(5, vacinacao.getDose());
			stmt.setInt(6, vacinacao.getNotaVacina());

			rs = stmt.getGeneratedKeys();
			int refIdGerado = 0;

			if (rs.next()) {
				int idGerado = rs.getInt(1);
				refIdGerado = idGerado;
				vacinacao.setId(idGerado);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao salvar registro de Vacinação");
			System.out.println("Erro: " + e.getMessage());

		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);

		}
		return vacinacao;

	}

	public boolean Atualizar(VacinaAplicada vacinacao) {
		Connection conn = Banco.getConnection();
		String sql = " UPDATE VACINAAPLICADA SET IDVACINA, IDPACIENTE,DATAAPLICACAO, PAISORIGEM, NOTAVACINA, DOSE"
				+ "WHERE ID=?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		boolean atualizou = false;
		try {
			stmt.setInt(1, vacinacao.getVacina().getId());
			stmt.setInt(2, vacinacao.getPaciente().getId());
			stmt.setDate(3, (Date) vacinacao.getDataAplicacao());
			stmt.setString(4, vacinacao.getPaisOrigem());
			stmt.setInt(5, vacinacao.getDose());

			int codigoRetorno = stmt.executeUpdate();

			if (codigoRetorno == 1) {
				atualizou = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar a vacinação.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return atualizou;

	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM VACINAAPLICADA WHERE ID= " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		boolean excluiu = false;
		try {
			stmt.setInt(1, id);

			int codigoRetorno = stmt.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);

		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacinação (id: " + id + ").\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;

	}

	private VacinaAplicada construirDoResultSet(ResultSet rs) {
		VacinaAplicada vacinacao = new VacinaAplicada();

		try {
			vacinacao.setId(rs.getInt("IDVACINAAPLICADA"));

			PessoaDao pessoaDao = new PessoaDao();
			int idPaciente = rs.getInt("IDPACIENTE");
			Pessoa paciente = (Pessoa) pessoaDao.pesquisarPorId(idPaciente);
			vacinacao.setPaciente(paciente);

			VacinaDao vacinaDao = new VacinaDao();
			int idVacina = rs.getInt("IDVACINA");
			Vacina vacina = (Vacina) vacinaDao.consultarPorId(idVacina);

			vacinacao.setDose(rs.getInt("Dose"));
			vacinacao.setPaisOrigem(rs.getString("País de Origem"));
			vacinacao.setNotaVacina(rs.getInt("Nota da Vacina"));
			vacinacao.setDataAplicacao(rs.getDate("Data da Aplicação"));

		} catch (SQLException e) {

		}
		return vacinacao;
	}

}

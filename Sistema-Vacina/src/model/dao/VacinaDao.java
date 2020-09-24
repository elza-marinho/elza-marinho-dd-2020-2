package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Vacina;

public class VacinaDao {
	public Vacina cadastrar(Vacina novaVacina) {
		Connection conn = Banco.getConnection();

		String sql = "INSERT INTO VACINA ( PAISORIGEM, DATAINICIO, ESTAGIOPESQUISA, NOMEPESQUISADOR )"
				+ " VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		try {
			
			stmt.setString(1, novaVacina.getPaisOrigem());
			stmt.setDate(2, (Date) novaVacina.getDataInicio());
			stmt.setInt(3, novaVacina.getEstagioPesquisa());
			stmt.setNString(4, novaVacina.getNomePesquisador());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			int refIdGerado = 0;

			if (rs.next()) {
				int idGerado = rs.getInt(1);
				refIdGerado = idGerado;
				novaVacina.setId(idGerado);

			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar nova Vacina");
			System.out.println("Erro: " + e.getMessage());

		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);

		}

		return novaVacina;
	}

	public boolean alterar(Vacina vacina) {
		Connection conn = Banco.getConnection();

		String sql = "UPDATE VACINA SET PAISORIGEM=?, DATAINICIO=?, ESTAGIOPESQUISA=?, NOMEPESQUISADOR=? " + "WHERE ID=?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		int registrosAlterados = 0;
		try {
			
			stmt.setString(1, vacina.getPaisOrigem());
			stmt.setDate(2, (Date) vacina.getDataInicio());
			stmt.setInt(3, vacina.getEstagioPesquisa());
			stmt.setString(4, vacina.getNomePesquisador());

			registrosAlterados = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar a vacina.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return registrosAlterados > 0;

	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM VACINA WHERE ID= " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		boolean excluiu = false;
		try {
			stmt.setInt(1, id);

			int codigoRetorno = stmt.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);

		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacina (id: " + id + ").\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;

	}

	public Vacina consultarPorId(int id) {
		String sql = "SELECT * FROM VACINA WHERE ID=?";
		Vacina vacinaConsultada = null;

		try (Connection conexao = Banco.getConnection();
				PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setInt(1, id);
			ResultSet conjuntoResultante = consulta.executeQuery();
			if (conjuntoResultante.next()) {
				vacinaConsultada = construirVacinaDoResultSet(conjuntoResultante);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar a vacina por id (id: " + id + "). \nCausa: " + e.getMessage());
		}
		return vacinaConsultada;

	}

	private Vacina construirVacinaDoResultSet(ResultSet conjuntoResultante) throws SQLException {
		Vacina vac = new Vacina();

		vac.setId(conjuntoResultante.getInt("Id"));
		vac.setPaisOrigem(conjuntoResultante.getString("País de Origem"));
		vac.setDataInicio(conjuntoResultante.getDate("Data de Início"));
		vac.setEstagioPesquisa(conjuntoResultante.getInt("Estágio da Pesquisa"));
		vac.setNomePesquisador(conjuntoResultante.getString("Nome do Pesquisador"));
		return vac;
	}

	public List<Vacina> pesquisarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM VACINA ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);

		ResultSet rs = null;

		ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vacina vac = construirVacinaDoResultSet(rs);
				vacinas.add(vac);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao listar Vacinas.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return vacinas;
	}
}

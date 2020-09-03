package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Pesquisador;
import model.vo.Vacina;

public class PesquisadorDao {

	public Pesquisador cadastrar(Pesquisador novoPesquisador) {
		Connection conn = Banco.getConnection();

		String sql = "INSERT INTO PESQUISADOR ( NOME, CPF, SEXO, DATANASCIMENTO, INSTITUICAO )"
				+ " VALUES (?, ?, ?, ?, ?,?)";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		try {

			stmt.setString(2, novoPesquisador.getNome());
			stmt.setString(3, novoPesquisador.getCpf());
			stmt.setString(4, novoPesquisador.getSexo() + "");
			stmt.setDate(5, (Date) novoPesquisador.getDataNascimento());
			stmt.setString(6, novoPesquisador.getInstituicao());
			stmt.execute();

			int refIdGerado = 0;

			if (rs.next()) {
				int idGerado = rs.getInt(1);
				refIdGerado = idGerado;
				novoPesquisador.setId(idGerado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar  Pesquisador");
			System.out.println("Erro: " + e.getMessage());

		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);

		}
		return novoPesquisador;
	}

	public boolean alterar(Pesquisador pesquisador) {

		String sql = "UPDATE PESQUISADOR" + "SET  NOME=?, SEXO=?, CPF=?, DATANASCIMENTO=?, INSTITUICAO=?";

		boolean alterado = false;
		try (Connection conexao = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);) {
			stmt.setString(1, pesquisador.getNome());
			stmt.setString(2, pesquisador.getSexo() + "");
			stmt.setString(3, pesquisador.getCpf());
			stmt.setDate(4, (Date) pesquisador.getDataNascimento());
			stmt.setString(5, pesquisador.getInstituicao());

			int codigoRetorno = stmt.executeUpdate();

			alterado = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);

		} catch (SQLException e) {
			System.out.println("Erro ao alterar pesquisador.\nCausa: " + e.getMessage());

		}
		return alterado;

	}

	public boolean excluir(int id) {
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM PESQUISADOR WHERE ID=? ";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		boolean excluido = false;
		try {
			stmt.setInt(1, id);

			int codigoRetorno = stmt.executeUpdate();
			excluido = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);

		} catch (SQLException e) {
			System.out.println("Erro ao excluir pesquisador (id: " + id + ").\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return excluido;

	}

	public Pesquisador consultarPorId(int id) {
		String sql = "SELECT * FROM PESQUISADOR WHERE ID=?";

		Pesquisador pesquisadorProcurado = null;

		try (Connection conn = Banco.getConnection();
				PreparedStatement consulta = Banco.getPreparedStatement(conn, sql);) {
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				pesquisadorProcurado = construirPesquisadorDoResultSet(rs);

			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pesquisador por Id(id: " + id + ").\nCausa: " + e.getMessage());
		}
		return pesquisadorProcurado;

	}

	private Pesquisador construirPesquisadorDoResultSet(ResultSet rs) throws SQLException {
		Pesquisador pesquisador = new Pesquisador();
		pesquisador.setId(rs.getInt("id"));
		pesquisador.setNome(rs.getString("some"));
		pesquisador.setSexo(rs.getString("sexo").charAt(0));
		pesquisador.setCpf(rs.getString("cpf"));
		pesquisador.setDataNascimento(rs.getDate("data de nascimento"));
		pesquisador.setInstituicao(rs.getString("institui��o"));

		return pesquisador;
	}

	public List<Pesquisador> pesquisarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM PESQUISADOR ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);

		ResultSet rs = null;
		ArrayList<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				Pesquisador pesquisador = construirPesquisadorDoResultSet(rs);
				pesquisadores.add(pesquisador);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar pesquisadores.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return pesquisadores;
	}

}

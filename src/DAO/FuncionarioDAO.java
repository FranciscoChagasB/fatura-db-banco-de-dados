package DAO;

import model.Funcionario;
import model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends ConexaoDB{
	
    private static final String INSERT_FUNCIONARIO_SQL = "INSERT INTO funcionario (codigo_funcionario, id_pessoa) VALUES (?, ?) ;";
    private static final String SELECT_FUNCIONARIO_BY_ID = "SELECT id, codigo_funcionario, id_pessoa FROM funcionario WHERE id = ?";
    private static final String SELECT_ALL_FUNCIONARIO = "SELECT * FROM funcionario;";
    private static final String DELETE_FUNCIONARIO_SQL = "DELETE FROM funcionario WHERE id = ?;";
    private static final String UPDATE_FUNCIONARIO_SQL = "UPDATE funcionario SET codigo_funcionario = ?, id_pessoa = ? WHERE id = ?;";

    PessoaDAO pessoaDAO = new PessoaDAO();
    public void insertFuncionario(Funcionario entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_FUNCIONARIO_SQL)) {
            preparedStatement.setString(1, entidade.getCodigoFuncionario());
            preparedStatement.setInt(2, entidade.getPessoaId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Funcionario selectFuncionarioById(int id) {
        Funcionario entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_FUNCIONARIO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String codigoFuncional = rs.getString("codigo_funcional");
                int pessoa_id = rs.getInt("pessoa_id");
                Pessoa pessoa = pessoaDAO.selectPessoaById(pessoa_id);
                entidade = new Funcionario(id, codigoFuncional, pessoa );
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Funcionario> selectAllFuncionario() {
        List<Funcionario> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_FUNCIONARIO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigoFuncional = rs.getString("codigo_funcional");
                int pessoa_id = rs.getInt("pessoa_id");
                Pessoa pessoa = pessoaDAO.selectPessoaById(pessoa_id);
                entidades.add(new Funcionario(id, codigoFuncional, pessoa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteFuncionario(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_FUNCIONARIO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updateFuncionarioi(Funcionario entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_FUNCIONARIO_SQL)) {
            statement.setString(1, entidade.getCodigoFuncionario());
            statement.setInt(2, entidade.getPessoaId());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
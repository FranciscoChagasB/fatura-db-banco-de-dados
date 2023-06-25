package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioDAO extends ConexaoDB{
	
	private static final String INSERT_FUNCIONARIO_SQL = "INSERT INTO funcionario (codigo_funcional, id_pessoa) VALUES (?, ?);";
    private static final String SELECT_FUNCIONARIO_BY_ID = "SELECT id, codigo_funcional, id_pessoa FROM funcionario WHERE id = ?";
    private static final String SELECT_ALL_FUNCIONARIO = "SELECT * FROM funcionario;";
    private static final String DELETE_FUNCIONARIO_SQL = "DELETE FROM funcionario WHERE id = ?;";
    private static final String UPDATE_FUNCIONARIO_SQL = "UPDATE funcionario SET codigo_funcional = ?, id_pessoa = ? WHERE id = ?;";
    
    public void insertFuncionario(Funcionario entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_FUNCIONARIO_SQL)) {
            preparedStatement.setString(1, entidade.getCodigoFuncional());
            preparedStatement.setInt(2, entidade.getIdPessoa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Funcionario selectFuncionario(int id) {
    	Funcionario entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_FUNCIONARIO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String codigo_funcional = rs.getString("codigo_funcional");
                Integer id_pessoa = rs.getInt("id_pessoa");
                entidade = new Funcionario(id, codigo_funcional, id_pessoa);
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
                String codigo_funcional = rs.getString("codigo_funcional");
                Integer id_pessoa = rs.getInt("id_pessoa");
                entidades.add(new Funcionario(id, codigo_funcional, id_pessoa));
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
    
    public boolean updateFuncionario(Funcionario entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_FUNCIONARIO_SQL)) {
            statement.setString(1, entidade.getCodigoFuncional());
            statement.setInt(2, entidade.getIdPessoa());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TipoPessoa;

public class TipoPessoaDAO extends ConexaoDB{

	private static final String INSERT_TIPOPESSOA_SQL = "INSERT INTO tipo_fase (descricao) VALUES (?);";
    private static final String SELECT_TIPOPESSOA_BY_ID = "SELECT id, descricao FROM tipo_fase WHERE id = ?";
    private static final String SELECT_ALL_TIPOPESSOA = "SELECT * FROM tipo_fase;";
    private static final String DELETE_TIPOPESSOA_SQL = "DELETE FROM tipo_fase WHERE id = ?;";
    private static final String UPDATE_TIPOPESSOA_SQL = "UPDATE tipo_fase SET descricao = ? WHERE id = ?;";
    
    public void insertTipoPessoa(TipoPessoa entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_TIPOPESSOA_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public TipoPessoa selectTipoPessoa(int id) {
    	TipoPessoa entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_TIPOPESSOA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                entidade = new TipoPessoa(id, descricao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    
    public List<TipoPessoa> selectAllTipoPessoa() {
        List<TipoPessoa> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_TIPOPESSOA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                entidades.add(new TipoPessoa(id, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
	
    public boolean deleteTipoPessoa(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_TIPOPESSOA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean updateTipoPessoa(TipoPessoa entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_TIPOPESSOA_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
}

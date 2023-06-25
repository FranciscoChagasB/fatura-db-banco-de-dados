package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import model.TarefaRota;

public class TarefaRotaDAO extends ConexaoDB{

	private static final String INSERT_TAREFAROTA_SQL = "INSERT INTO tarefa_rota (observacao, data_inicio, data_fim, id_rota) VALUES (?, ?, ?, ?);";
    private static final String SELECT_TAREFAROTA_BY_ID = "SELECT id, observacao, data_inicio, data_fim, id_rota FROM tarefa_rota WHERE id = ?";
    private static final String SELECT_ALL_TAREFAROTA = "SELECT * FROM tarefa_rota;";
    private static final String DELETE_TAREFAROTA_SQL = "DELETE FROM tarefa_rota WHERE id = ?;";
    private static final String UPDATE_TAREFAROTA_SQL = "UPDATE tarefa_rota SET observacao = ?, data_inicio = ?, data_fim = ?, id_rota = ? WHERE id = ?;";
    
    public void insertTarefaRota(TarefaRota entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_TAREFAROTA_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setTimestamp(2, entidade.getDataInicio());
            preparedStatement.setTimestamp(3, entidade.getDataFim());
            preparedStatement.setInt(4, entidade.getIdRota());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public TarefaRota selectTarefaRota(int id) {
    	TarefaRota entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_TAREFAROTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Timestamp data_inicio = rs.getTimestamp("data_inicio");
                Timestamp data_fim = rs.getTimestamp("data_fim");
                Integer id_rota = rs.getInt("id_rota");
                entidade = new TarefaRota(id, observacao, data_inicio, data_fim, id_rota);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    
    public List<TarefaRota> selectAllTarefaRota() {
        List<TarefaRota> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_TAREFAROTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Timestamp data_inicio = rs.getTimestamp("data_inicio");
                Timestamp data_fim = rs.getTimestamp("data_fim");
                Integer id_rota = rs.getInt("id_rota");
                entidades.add(new TarefaRota(id, observacao, data_inicio, data_fim, id_rota));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
	
    public boolean deleteTarefaRota(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_TAREFAROTA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean updateTarefaRota(TarefaRota entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_TAREFAROTA_SQL)) {
        	statement.setString(1, entidade.getObservacao());
            statement.setTimestamp(2, entidade.getDataInicio());
            statement.setTimestamp(3, entidade.getDataFim());
            statement.setInt(4, entidade.getIdRota());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
}

package DAO;

import model.Rota;
import model.TarefaRota;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TarefaRotaDAO extends ConexaoDB{

    private static final String INSERT_TAREFA_ROTA_SQL = "INSERT INTO tarefa_rota (observacao, data_inicio, data_fim, tarefa_rotcao, id_rota) VALUES (?, ?, ?, ?, ?) ;";
    private static final String SELECT_TAREFA_ROTA_BY_ID = "SELECT id, observacao, data_inicio, data_fim, tarefa_rotcao, id_rota FROM tarefa_rota WHERE id = ?";
    private static final String SELECT_ALL_TAREFA_ROTA = "SELECT * FROM tarefa_rota;";
    private static final String DELETE_TAREFA_ROTA_SQL = "DELETE FROM tarefa_rota WHERE id = ?;";
    private static final String UPDATE_TAREFA_ROTA_SQL = "UPDATE tarefa_rota SET observacao = ?,  data_inicio = ?, data_fim = ?,  tarefa_rotcao = ?, id_rota = ? WHERE id = ?;";

    private RotaDAO rotaDAO = new RotaDAO();

    public void insertTarefaRota(TarefaRota entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_TAREFA_ROTA_SQL)) {
            preparedStatement.setString(1, entidade.getObervacao());
            preparedStatement.setTimestamp(2, entidade.getDataInicio());
            preparedStatement.setTimestamp(3, entidade.getDataFinal());
            preparedStatement.setString(4, entidade.getTarefaRotcao());
            preparedStatement.setInt(5, entidade.getRotaId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TarefaRota selectTarefaRotaById(int id) {
        TarefaRota entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_TAREFA_ROTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String obervacao = rs.getString("observacao");
                Timestamp dataInicio = rs.getTimestamp("data_inicio");
                Timestamp dataFim = rs.getTimestamp("data_fim");
                String tarefaRotcao = rs.getString("tarefa_rotcao");
                int rotaId = rs.getInt("rota_id");
                Rota rota = rotaDAO.selectRota(rotaId);

                entidade = new TarefaRota(id, obervacao, dataInicio, dataFim, tarefaRotcao, rota );
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
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_TAREFA_ROTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String obervacao = rs.getString("observacao");
                Timestamp dataInicio = rs.getTimestamp("data_inicio");
                Timestamp dataFim = rs.getTimestamp("data_fim");
                String tarefaRotcao = rs.getString("tarefa_rotcao");
                int rotaId = rs.getInt("rota_id");
                Rota rota = rotaDAO.selectRota(rotaId);


                entidades.add(new TarefaRota(id, obervacao, dataInicio, dataFim, tarefaRotcao, rota ));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteTarefaRota(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_TAREFA_ROTA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTarefaRota(TarefaRota entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_TAREFA_ROTA_SQL)) {

            statement.setString(1, entidade.getObervacao());
            statement.setTimestamp(2, entidade.getDataInicio());
            statement.setTimestamp(3, entidade.getDataFinal());
            statement.setString(4, entidade.getTarefaRotcao());
            statement.setInt(5, entidade.getRotaId());
            statement.setInt(6, entidade.getId());


            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
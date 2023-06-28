package DAO;

import model.Funcionario;
import model.TarefaRota;
import model.TimeRota;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TimeRotaDAO extends ConexaoDB{

    private static final String INSERT_TIME_ROTA_SQL = "INSERT INTO time_rota (id_funcionario, id_tarefa_rota) VALUES (?, ?) ;";
    private static final String SELECT_TIME_ROTA_BY_ID = "SELECT id, id_funcionario, id_tarefa_rota FROM time_rota WHERE id = ?";
    private static final String SELECT_ALL_TIME_ROTA = "SELECT * FROM time_rota;";
    private static final String DELETE_TIME_ROTA_SQL = "DELETE FROM time_rota WHERE id = ?;";
    private static final String UPDATE_TIME_ROTA_SQL = "UPDATE time_rota SET id_funcionario = ?, id_tarefa_rota = ?  WHERE id = ?;";

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private TarefaRotaDAO tarefarotaDAO = new TarefaRotaDAO();

    public void insertTimeRotaSQL(TimeRota entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_TIME_ROTA_SQL)) {
            preparedStatement.setInt(1, entidade.getFuncionarioId());
            preparedStatement.setInt(2, entidade.getTarefaRotaId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TimeRota selectTimeRotaById(int id) {
        TimeRota entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_TIME_ROTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer funcionarioId = rs.getInt("funcionario_id");
                Funcionario funcionario = funcionarioDAO.selectFuncionario(funcionarioId);
                Integer tarefaRotaId = rs.getInt("tarefa_rota_id");
                TarefaRota tarefa_rota = tarefarotaDAO.selectTarefaRota(tarefaRotaId);
                entidade = new TimeRota(id, funcionario, tarefa_rota );
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<TimeRota> selectAllTimeRota() {
        List<TimeRota> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_TIME_ROTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Integer funcionarioId = rs.getInt("funcionario_id");
                Funcionario funcionario = funcionarioDAO.selectFuncionario(funcionarioId);
                Integer tarefaRotaId = rs.getInt("tarefa_rota_id");
                TarefaRota tarefa_rota = tarefarotaDAO.selectTarefaRota(tarefaRotaId);
                entidades.add( new TimeRota(id, funcionario, tarefa_rota ));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteTimeRota(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_TIME_ROTA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTimeRota(TimeRota entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_TIME_ROTA_SQL)) {
            statement.setInt(1, entidade.getFuncionarioId());
            statement.setInt(2, entidade.getTarefaRotaId());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
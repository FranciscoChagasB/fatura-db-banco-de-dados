package DAO;

import model.Medicao;
import model.Medidor;
import model.TimeRota;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MedicaoDAO extends  ConexaoDB{
	
    private static final String INSERT_MEDICAO_SQL = "INSERT INTO medicao (mes, ano, data_medicao, consumo, id_medidor, id_time_rota) VALUES (?, ?, ?, ?, ?, ?) ;";
    private static final String SELECT_MEDICAO_BY_ID = "SELECT id, mes, ano, data_medicao, consumo, id_medidor, id_time_rota FROM medicao WHERE id = ?";
    private static final String SELECT_ALL_MEDICAO= "SELECT * FROM medicao;";
    private static final String DELETE_MEDICAO_SQL = "DELETE FROM medicao WHERE id = ?;";
    private static final String UPDATE_MEDICAO_SQL = "UPDATE medicao SET mes = ?, ano = ?, data_medicao = ?, consumo = ?, id_medidor = ?, id_time_rota = ? WHERE id = ?;";

    private static MedidorDAO medidorDAO = new MedidorDAO();
    private static TimeRotaDAO timeRotaDAO = new TimeRotaDAO();
    
    public void insertMedicao(Medicao entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_MEDICAO_SQL)) {
            preparedStatement.setString(1, entidade.getMes());
            preparedStatement.setString(2, entidade.getAno());
            preparedStatement.setTimestamp(3, entidade.getDataMedicao());
            preparedStatement.setString(4, entidade.getConsumo());
            preparedStatement.setInt(5, entidade.getMedidorId());
            preparedStatement.setInt(6, entidade.getTimeRotaId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Medicao selectMedicaoById(int id) {
        Medicao entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MEDICAO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String mes = rs.getString("mes");
                String ano = rs.getString("ano");
                Timestamp data_medicao = rs.getTimestamp("data_medicao");
                String consumo = rs.getString("consumo");
                int medidor_id = rs.getInt("medidor_id");
                Medidor medidor = medidorDAO.selectMedidorById(medidor_id);
                int time_rota_id = rs.getInt("time_rota_id");
                TimeRota time_rota = timeRotaDAO.selectTimeRota(time_rota_id);
                entidade = new Medicao(id, mes, ano, data_medicao, consumo, medidor, time_rota);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Medicao> selectAllTarifa() {
        List<Medicao> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MEDICAO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String mes = rs.getString("mes");
                String ano = rs.getString("ano");
                Timestamp data_medicao = rs.getTimestamp("data_medicao");
                String consumo = rs.getString("consumo");
                int medidor_id = rs.getInt("medidor_id");
                Medidor medidor = medidorDAO.selectMedidorById(medidor_id);
                int time_rota_id = rs.getInt("time_rota_id");
                TimeRota time_rota = timeRotaDAO.selectTimeRota(time_rota_id);
                entidades.add(new Medicao(id, mes, ano, data_medicao, consumo, medidor, time_rota));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedicao(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_MEDICAO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedicao(Medicao entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_MEDICAO_SQL)) {
            statement.setString(1, entidade.getMes());
            statement.setString(2, entidade.getAno());
            statement.setTimestamp(3, entidade.getDataMedicao());
            statement.setString(4, entidade.getConsumo());
            statement.setInt(5, entidade.getMedidorId());
            statement.setInt(6, entidade.getTimeRotaId());
            statement.setInt(7, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
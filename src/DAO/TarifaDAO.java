package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarifa;

public class TarifaDAO extends ConexaoDB{

	private static final String INSERT_TARIFA_SQL = "INSERT INTO tarifa (taxa, lei, data_inicio, data_fim, aliquota_ICMS, id_classe) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_TARIFA_BY_ID = "SELECT taxa, lei, data_inicio, data_fim, aliquota_ICMS, id_classe FROM tarifa WHERE id = ?";
    private static final String SELECT_ALL_TARIFA = "SELECT * FROM tarifa;";
    private static final String DELETE_TARIFA_SQL = "DELETE FROM tarifa WHERE id = ?;";
    private static final String UPDATE_TARIFA_SQL = "UPDATE tarifa SET taxa = ?, lei = ?, data_inicio = ?, data_fim = ?, aliquota_ICMS = ?, id_classe = ? WHERE id = ?;";
    
    public void insertTarifa(Tarifa entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_TARIFA_SQL)) {
            preparedStatement.setString(1, entidade.getTaxa());
            preparedStatement.setString(2, entidade.getLei());
            preparedStatement.setString(3, entidade.getDataInicio());
            preparedStatement.setString(4, entidade.getDataFim());
            preparedStatement.setString(5, entidade.getAliquotaICMS());
            preparedStatement.setInt(6, entidade.getIdClasse());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Tarifa selectTarifa(int id) {
    	Tarifa entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_TARIFA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String taxa = rs.getString("taxa");
                String lei = rs.getString("lei");
                String data_inicio = rs.getString("data_inicio");
                String data_fim = rs.getString("data_fim");
                String aliquota_ICMS = rs.getString("aliquota_ICMS");
                Integer id_classe = rs.getInt("id_classe");
                entidade = new Tarifa(id, taxa, lei, data_inicio, data_fim, aliquota_ICMS, id_classe);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    
    public List<Tarifa> selectAllTarifa() {
        List<Tarifa> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_TARIFA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String taxa = rs.getString("taxa");
                String lei = rs.getString("lei");
                String data_inicio = rs.getString("data_inicio");
                String data_fim = rs.getString("data_fim");
                String aliquota_ICMS = rs.getString("aliquota_ICMS");
                Integer id_classe = rs.getInt("id_classe");
                entidades.add(new Tarifa(id, taxa, lei, data_inicio, data_fim, aliquota_ICMS, id_classe));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
	
    public boolean deleteTarifa(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_TARIFA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean updateTarifa(Tarifa entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_TARIFA_SQL)) {
        	statement.setString(1, entidade.getTaxa());
        	statement.setString(2, entidade.getLei());
            statement.setString(3, entidade.getDataInicio());
            statement.setString(4, entidade.getDataFim());
            statement.setString(5, entidade.getAliquotaICMS());
            statement.setInt(4, entidade.getIdClasse());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
	
}

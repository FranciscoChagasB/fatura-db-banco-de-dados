package DAO;

import model.Rota;
import model.Poste;
import model.Medidor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedidorDAO extends  ConexaoDB{
	
    private static final String INSERT_MEDIDOR_SQL = "INSERT INTO medidor (descricao, id_rota, id_poste) VALUES (?, ?, ?) ;";
    private static final String SELECT_MEDIDOR_BY_ID = "SELECT id, descricao, id_rota, id_poste FROM medidor WHERE id = ?";
    private static final String SELECT_ALL_MEDIDOR = "SELECT * FROM medidor;";
    private static final String DELETE_MEDIDOR_SQL = "DELETE FROM medidor WHERE id = ?;";
    private static final String UPDATE_MEDIDOR_SQL = "UPDATE medidor SET descricao = ?, id_rota = ?, id_poste = ? WHERE id = ?;";

    private static final PosteDAO posteDAO = new PosteDAO();
    private static final RotaDAO rotaDAO = new RotaDAO();

    public void insertMedidor(Medidor entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_MEDIDOR_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getRotaId());
            preparedStatement.setInt(3, entidade.getPosteId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Medidor selectMedidorById(int id) {
        Medidor entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MEDIDOR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer rota_id = rs.getInt("rota_id");
                Rota rota = rotaDAO.selectRota(rota_id);
                Integer poste_id = rs.getInt("poste_id");
                Poste poste = posteDAO.selectPosteById(rota_id);
                entidade = new Medidor(id, descricao, rota, poste);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Medidor> selectAllMedidor() {
        List<Medidor> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MEDIDOR)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Integer rota_id = rs.getInt("rota_id");
                Rota rota = rotaDAO.selectRota(rota_id);
                Integer poste_id = rs.getInt("poste_id");
                Poste poste = posteDAO.selectPosteById(rota_id);
                entidades.add(new Medidor(id, descricao, rota, poste));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedidor(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_MEDIDOR_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedidor(Medidor entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_MEDIDOR_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getRotaId());
            statement.setInt(3, entidade.getPosteId());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
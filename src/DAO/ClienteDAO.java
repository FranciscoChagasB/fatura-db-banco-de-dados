package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO extends ConexaoDB{

	private static final String INSERT_CLIENTE_SQL = "INSERT INTO cliente (num_documento, num_cliente, id_pessoa) VALUES (?, ?, ?);";
    private static final String SELECT_CLIENTE_BY_ID = "SELECT id, num_documento, num_cliente, id_pessoa FROM cliente WHERE id = ?";
    private static final String SELECT_ALL_CLIENTE = "SELECT * FROM cliente;";
    private static final String DELETE_CLIENTE_SQL = "DELETE FROM cliente WHERE id = ?;";
    private static final String UPDATE_CLIENTE_SQL = "UPDATE pessoa SET num_documento = ?, num_cliente = ?, id_pessoa = ? WHERE id = ?;";
    
    public void insertCliente(Cliente entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CLIENTE_SQL)) {
            preparedStatement.setString(1, entidade.getNumDocumento());
            preparedStatement.setString(2, entidade.getNumCliente());
            preparedStatement.setInt(3, entidade.getIdPessoa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Cliente selectCliente(int id) {
    	Cliente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CLIENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String num_documento = rs.getString("num_documento");
                String num_cliente = rs.getString("num_cliente");
                Integer id_pessoa = rs.getInt("id_pessoa");
                entidade = new Cliente(id, num_documento, num_cliente, id_pessoa);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    
    public List<Cliente> selectAllCliente() {
        List<Cliente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CLIENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String num_documento = rs.getString("num_documento");
                String num_cliente = rs.getString("num_cliente");
                Integer id_pessoa = rs.getInt("id_pessoa");
                entidades.add(new Cliente(id, num_documento, num_cliente, id_pessoa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
	
    public boolean deleteCliente(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CLIENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean updateCliente(Cliente entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CLIENTE_SQL)) {
            statement.setString(1, entidade.getNumDocumento());
            statement.setString(2, entidade.getNumCliente());
            statement.setInt(3, entidade.getIdPessoa());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
}

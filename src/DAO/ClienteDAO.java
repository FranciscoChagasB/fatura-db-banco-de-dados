package DAO;

import model.Cliente;
import model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends  ConexaoDB{
	
    private static final String INSERT_CLIENTE_SQL = "INSERT INTO cliente (num_documento, num_cliente, id_pessoa) VALUES (?, ?, ?) ;";
    private static final String SELECT_CLIENTE_BY_ID = "SELECT id, num_documento, num_cliente, id_pessoa FROM cliente WHERE id = ?";
    private static final String SELECT_ALL_CLIENTE = "SELECT * FROM cliente;";
    private static final String DELETE_CLIENTE_SQL = "DELETE FROM cliente WHERE id = ?;";
    private static final String UPDATE_CLIENTE_SQL = "UPDATE cliente SET num_documento = ?, num_cliente = ?, id_pessoa = ? WHERE id = ?;";

    PessoaDAO pessoaDAO = new PessoaDAO();
    
    public void insertCliente(Cliente entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CLIENTE_SQL)) {
            preparedStatement.setString(1, entidade.getNumDocumento());
            preparedStatement.setString(2, entidade.getNumCliente());
            preparedStatement.setInt(3, entidade.getPessoaId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente selectClienteById(int id) {
        Cliente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CLIENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String num_documento = rs.getString("num_documento");
                String num_cliente = rs.getString("num_cliente");
                int pessoa_id = rs.getInt("id_pessoa");
                Pessoa pessoa = pessoaDAO.selectPessoaById(pessoa_id);
                entidade = new Cliente(id, num_cliente, num_documento, pessoa);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Cliente> selectAllCliente() {
        List<Cliente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CLIENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String num_documento = rs.getString("num_documento");
                String num_cliente = rs.getString("num_cliente");
                int pessoa_id = rs.getInt("id_pessoa");
                Pessoa pessoa = pessoaDAO.selectPessoaById(pessoa_id);
                entidades.add(new Cliente(id, num_documento, num_cliente, pessoa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (Exception e) {
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
            statement.setInt(3, entidade.getPessoaId());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
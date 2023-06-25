package DAO;

import model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends ConexaoDB{
	
	private static final String INSERT_PESSOA_SQL = "INSERT INTO pessoa (nome, cpf, cnpj, id_tipo_pessoa) VALUES (?, ?, ?, ?);";
    private static final String SELECT_PESSOA_BY_ID = "SELECT id, nome, cpf, cnpj, id_tipo_pessoa FROM pessoa WHERE id = ?";
    private static final String SELECT_ALL_PESSOA = "SELECT * FROM pessoa;";
    private static final String DELETE_PESSOA_SQL = "DELETE FROM pessoa WHERE id = ?;";
    private static final String UPDATE_PESSOA_SQL = "UPDATE pessoa SET nome = ?, cpf = ?, cnpj = ?, id_tipo_pessoa = ? WHERE id = ?;";
    
    public void insertPessoa(Pessoa entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_PESSOA_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getCpf());
            preparedStatement.setString(3, entidade.getCnpj());
            preparedStatement.setInt(4, entidade.getIdTipoPessoa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Pessoa selectPessoa(int id) {
    	Pessoa entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_PESSOA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");
                Integer id_tipopessoa = rs.getInt("id_tipo_pessoa");
                entidade = new Pessoa(id, nome, cpf, cnpj, id_tipopessoa);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    
    public List<Pessoa> selectAllPessoa() {
        List<Pessoa> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_PESSOA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");
                Integer id_tipopessoa = rs.getInt("id_tipo_pessoa");
                entidades.add(new Pessoa(id, nome, cpf, cnpj, id_tipopessoa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
	
    public boolean deletePessoa(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_PESSOA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean updatePessoa(Pessoa entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_PESSOA_SQL)) {
            statement.setString(1, entidade.getNome());
            statement.setString(2, entidade.getCpf());
            statement.setString(3, entidade.getCnpj());
            statement.setInt(4, entidade.getIdTipoPessoa());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
}

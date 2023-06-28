package DAO;

import model.Pessoa;
import model.TipoPessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends  ConexaoDB{
	
    private static final String INSERT_PESSOA_SQL = "INSERT INTO pessoa (nome, cpf, cnpj, id_tipo_pessoa) VALUES (?, ?, ?, ?) ;";
    private static final String SELECT_PESSOA_BY_ID = "SELECT id, nome, cpf, cnpj, id_tipo_pessoa FROM pessoa WHERE id = ?";
    private static final String SELECT_ALL_PESSOA = "SELECT * FROM pessoa;";
    private static final String DELETE_PESSOA_SQL = "DELETE FROM pessoa WHERE id = ?;";
    private static final String UPDATE_PESSOA_SQL = "UPDATE pessoa SET nome = ?, cpf = ?, cnpj = ?, id_tipo_pessoa = ? WHERE id = ?;";

    private static final TipoPessoaDAO tipoPessoaDao = new TipoPessoaDAO();

    public void insertPessoa(Pessoa entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_PESSOA_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getCpf());
            preparedStatement.setInt(4, entidade.getTipoPessoaId());

            if (entidade.getCnpj() == null || entidade.getCnpj().isEmpty()) {
                preparedStatement.setNull(3, 0);
                preparedStatement.executeUpdate();
                return;
            }

            preparedStatement.setString(3, entidade.getCnpj());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Pessoa selectPessoaById(int id) {
        Pessoa entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_PESSOA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Integer tipo_pessoa_id = rs.getInt("id_tipo_pessoa");
                TipoPessoa tipo_pessoa = tipoPessoaDao.selectTipoPessoaById(tipo_pessoa_id);
                entidade = new Pessoa(id, nome, cpf, tipo_pessoa);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Pessoa> selectAllPessoa() {
        List<Pessoa> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_PESSOA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Integer tipo_pessoa_id = rs.getInt("id_tipo_pessoa");
                TipoPessoa tipo_pessoa = tipoPessoaDao.selectTipoPessoaById(tipo_pessoa_id);
                entidades.add(new Pessoa(id, nome, cpf, tipo_pessoa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (Exception e) {
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
            statement.setInt(4, entidade.getTipoPessoaId());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
package DAO;

import model.RetornaDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetornaDadosDAO extends ConexaoDB{

	private static final String SELECT_RETORNADADOS_BY_ID ="SELECT * FROM tipo_fase " +
		    "INNER JOIN classe ON classe.id_tipo_fase = tipo_fase.id " +
		    "INNER JOIN tarifa ON tarifa.id_classe = classe.id " +
		    "INNER JOIN contrato ON contrato.id_classe = classe.id " +
		    "INNER JOIN medidor ON medidor.id = contrato.id_medidor " +
		    "INNER JOIN rota ON rota.id = medidor.id_rota " +
		    "INNER JOIN poste ON poste.id = medidor.id_poste " +
		    "INNER JOIN cliente ON cliente.id = contrato.id_cliente " +
		    "INNER JOIN pessoa ON pessoa.id = cliente.id_pessoa " +
		    "INNER JOIN tarefa_rota ON tarefa_rota.id_rota = rota.id " +
		    "WHERE pessoa.id = ?; ";
	
	public RetornaDados selectRetornaDadosById(int id) {
		RetornaDados entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_RETORNADADOS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String poste = rs.getString("poste");
                String nome = rs.getString("nome");
                String classe = rs.getString("classe");
                String cnpj = rs.getString("cnpj");
                String cpf = rs.getString("cpf");
                String tipoFase = rs.getString("tipo_fase");
                entidade = new RetornaDados(id, cpf, poste, nome, cnpj, classe, tipoFase);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entidade;
	}
}
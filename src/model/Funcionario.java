package model;

import DAO.PessoaDAO;

public class Funcionario extends GenericModel {
	
	private String codigo_funcionario;
    private Pessoa pessoaId;

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public Funcionario(String codigoFuncionario, Pessoa pessoaId) {
        this.codigo_funcionario = codigoFuncionario;
        this.pessoaId = pessoaId;
    }
    public Funcionario(int id, String codigoFuncionario, Pessoa pessoaId) {
        this.codigo_funcionario = codigoFuncionario;
        this.pessoaId = pessoaId;
        super.setId(id);
    }

    public String getCodigoFuncionario() {
        return codigo_funcionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigo_funcionario = codigoFuncionario;
    }

    public int getPessoaId() {
        return pessoaId.getId();
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id='" + this.getId() + '\'' +
                ", codigo_funcionario='" + getCodigoFuncionario() + '\'' +
                ", id_pessoa='" + getPessoaId() + '\'' +
                '}';
    }
}
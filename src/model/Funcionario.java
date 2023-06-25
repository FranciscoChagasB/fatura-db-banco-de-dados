package model;

import DAO.PessoaDAO;

public class Funcionario extends GenericModel {
    private String codigo_funcional;
    private Integer id_pessoa;
    
    static PessoaDAO pessoaDAO = new PessoaDAO();

    public Funcionario(String codigo_funcional, Integer id_pessoa) {
        this.codigo_funcional = codigo_funcional;
        this.id_pessoa = id_pessoa;
    }
    
    public Funcionario(Integer id, String codigo_funcional, Integer id_pessoa) {
        this.codigo_funcional = codigo_funcional;
        this.id_pessoa = id_pessoa;
        super.setId(id);
    }

    public String getCodigoFuncional() {
        return codigo_funcional;
    }

    public void setCodigoFuncional(String codigo_funcional) {
        this.codigo_funcional = codigo_funcional;
    }

    public Integer getIdPessoa() {
        return id_pessoa;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id='" + this.getId() + '\'' +
                ", codigo_funcional='" + codigo_funcional + '\'' +
                ", id_pessoa='" + pessoaDAO.selectPessoa(id_pessoa) + '\'' +
                '}';
    }
}
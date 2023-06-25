package model;
import DAO.*;

public class Pessoa extends GenericModel{

	private String nome;
	private String cpf;
	private String cnpj;
    private Integer id_tipo_pessoa;
    
    static TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
    

    public Pessoa(String nome, String cpf, String cnpj, Integer id_tipo_pessoa) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.id_tipo_pessoa = id_tipo_pessoa;
    }
    
    public Pessoa(Integer id, String nome, String cpf, String cnpj, Integer id_tipo_pessoa) {
    	this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.id_tipo_pessoa = id_tipo_pessoa;
        super.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getIdTipoPessoa() {
    	return id_tipo_pessoa;
    }
    
    
    @Override
    public String toString() {
        return "Pessoa {" +
                "id='" + this.getId() + "\'" +
                ", nome='" + nome + "\'" +
                ", cpf='" + cpf + "\'" +
                ", cnpj='" + cnpj + "\'" +
                ", id_tipo_pessoa='" + tipoPessoaDAO.selectTipoPessoa(id_tipo_pessoa) + "\'" +
                '}';
    }
	
}

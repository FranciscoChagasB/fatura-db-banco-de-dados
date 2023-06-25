package model;
import DAO.*;

public class Cliente extends GenericModel {
    private String num_documento;
    private String num_cliente;
    private Integer id_pessoa;
    
    static PessoaDAO pessoaDAO = new PessoaDAO();

    public Cliente(String num_documento, String num_cliente, Integer id_pessoa) {
        this.num_documento = num_documento;
        this.num_cliente = num_cliente;
        this.id_pessoa = id_pessoa;
    }
    
    public Cliente(Integer id, String num_documento, String num_cliente, Integer id_pessoa) {
        this.num_documento = num_documento;
        this.num_cliente = num_cliente;
        this.id_pessoa = id_pessoa;
        super.setId(id);
    }

    public String getNumDocumento() {
        return num_documento;
    }

    public void setNumDocumento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getNumCliente() {
        return num_cliente;
    }

    public void setNumCliente(String num_cliente) {
        this.num_cliente = num_cliente;
    }

    public Integer getIdPessoa() {
        return id_pessoa;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "id='" + this.getId() + '\'' +
                ", num_documento='" + num_documento + '\'' +
                ", num_cliente='" + num_cliente + '\'' +
                ", id_pessoa='" + pessoaDAO.selectPessoa(id_pessoa) + '\'' +
                '}';
    }
}
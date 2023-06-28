package model;

import DAO.*;

public class Cliente extends GenericModel {
	
	private String num_documento;
    private String num_cliente;
    private Pessoa pessoaId;

    static PessoaDAO pessoaDAO = new PessoaDAO();

    public Cliente(String numDocumento, String numCliente, Pessoa pessoaId) {
        this.num_documento = numDocumento;
        this.num_cliente = numCliente;
        this.pessoaId = pessoaId;
    }
    public Cliente(Integer id, String numCliente, String numDocumento, Pessoa pessoaId){
        this.num_documento = numDocumento;
        this.num_cliente = numCliente;
        this.pessoaId = pessoaId;
        super.setId(id);
    }

    public String getNumDocumento() {
        return num_documento;
    }

    public void setNumDocumento(String numDocumento) {
        this.num_documento = numDocumento;
    }

    public String getNumCliente() {
        return num_cliente;
    }

    public void setNumCliente(String numCliente) {
        this.num_cliente = numCliente;
    }

    public int getPessoaId() {
        return pessoaId.getId();
    }
    
    @Override
    public String toString() {
        return "Cliente {" +
                "id='" + this.getId() + '\'' +
                ", num_documento='" + getNumDocumento() + '\'' +
                ", num_cliente='" + getNumCliente() + '\'' +
                ", id_pessoa='" + getPessoaId() + '\'' +
                '}';
    }
}
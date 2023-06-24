package model;

import java.util.Date;

public class Contrato extends GenericModel {
    private String descricao;
    private Date data_inicio;
    private Date data_criacao;
    private Integer id_medidor;
    private Integer id_classe;
    private Integer id_cliente;

    public Contrato(String descricao, Date data_inicio, Date data_criacao, Integer id_medidor,
                    Integer id_classe, Integer id_cliente) {
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_criacao = data_criacao;
        this.id_medidor = id_medidor;
        this.id_classe = id_classe;
        this.id_cliente = id_cliente;
    }
    
    public Contrato(Integer id, String descricao, Date data_inicio, Date data_criacao, Integer id_medidor,
    		Integer id_classe, Integer id_cliente) {
    	this.descricao = descricao;
    	this.data_inicio = data_inicio;
    	this.data_criacao = data_criacao;
    	this.id_medidor = id_medidor;
    	this.id_classe = id_classe;
    	this.id_cliente = id_cliente;
    	super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return data_inicio;
    }

    public void setDataInicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getDataCriacao() {
        return data_criacao;
    }

    public void setDataCriacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Integer getIdMedidor() {
        return id_medidor;
    }

    public void setIdMedidor(Integer id_medidor) {
        this.id_medidor = id_medidor;
    }

    public Integer getIdClasse() {
        return id_classe;
    }

    public void setIdClasse(Integer id_classe) {
        this.id_classe = id_classe;
    }

    public Integer getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id='" + this.getId() + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data_inicio='" + data_inicio + '\'' +
                ", data_criacao='" + data_criacao + '\'' +
                ", id_medidor='" + id_medidor + '\'' +
                ", id_classe='" + id_classe + '\'' +
                ", id_cliente='" + id_cliente + '\'' +
                '}';
    }
}
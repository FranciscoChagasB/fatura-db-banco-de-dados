package model;

import java.sql.Timestamp;

public class Contrato extends GenericModel {
	
	private String descricao;
    private Timestamp data_inicio;
    private Timestamp data_criacao;
    private Medidor medidorId;
    private Classe classeId;
    private Cliente clienteId;

    public Contrato(String descricao, Timestamp dataInicio, Timestamp dataCriacao, Medidor medidorId, Classe classeId, Cliente clienteId) {
        this.descricao = descricao;
        this.data_inicio = dataInicio;
        this.data_criacao = dataCriacao;
        this.medidorId = medidorId;
        this.classeId = classeId;
        this.clienteId = clienteId;
    }
    public Contrato(int id, String descricao, Timestamp dataInicio, Timestamp dataCriacao, Medidor medidorId, Classe classeId, Cliente clienteId) {
        this.descricao = descricao;
        this.data_inicio = dataInicio;
        this.data_criacao = dataCriacao;
        this.medidorId = medidorId;
        this.classeId = classeId;
        this.clienteId = clienteId;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getDataInicio() {
        return data_inicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.data_inicio = dataInicio;
    }

    public Timestamp getDataCriacao() {
        return data_criacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.data_criacao = dataCriacao;
    }

    public int getMedidorId() {
        return medidorId.getId();
    }

    public int getClasseId() {
        return classeId.getId();
    }

    public int getClienteId() {
        return clienteId.getId();
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id='" + this.getId() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data_inicio='" + getDataInicio() + '\'' +
                ", data_criacao='" + getDataCriacao() + '\'' +
                ", id_medidor='" + getMedidorId() + '\'' +
                ", id_classe='" + getClasseId() + '\'' +
                ", id_cliente='" + getClienteId() + '\'' +
                '}';
    }
}
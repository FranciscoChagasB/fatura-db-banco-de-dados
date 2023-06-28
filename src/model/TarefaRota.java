package model;

import java.sql.Timestamp;

import DAO.*;

public class TarefaRota extends  GenericModel {
	
    private String observacao;
    private Timestamp data_inicio;
    private Timestamp data_fim;
    private Rota rotaId;

    static RotaDAO rotaDAO = new RotaDAO();

    public TarefaRota(String observacao, Timestamp dataInicio, Timestamp dataFim, Rota rotaId) {
        this.observacao = observacao;
        this.data_inicio = dataInicio;
        this.data_fim = dataFim;
        this.rotaId = rotaId;
    }

    public TarefaRota(Integer id, String observacao, Timestamp dataInicio, Timestamp dataFim, Rota rotaId) {
        this.observacao = observacao;
        this.data_inicio = dataInicio;
        this.data_fim = dataFim;
        this.rotaId = rotaId;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Timestamp getDataInicio() {
        return data_inicio;
    }

    public void setDataInicio(Timestamp data_inicio) {
        this.data_inicio = data_inicio;
    }
    
    public Timestamp getDataFim() {
        return data_fim;
    }
    
    public void setDataFim(Timestamp data_fim) {
        this.data_fim = data_fim;
    }

    public int getRotaId() {
        return rotaId.getId();
    }
    
    @Override
    public String toString() {
        return "TarefaRota {" +
                "id='" + this.getId() + "\'" +
                ", observacao='" + getObservacao() + "\'" +
                ", data_inicio='" + getDataInicio() + "\'" +
                ", data_fim='" + getDataFim() + "\'" +
                ", id_rota='" + getRotaId() + "\'" +
                '}';
    }
	
}

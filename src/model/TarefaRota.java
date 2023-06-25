package model;

import java.sql.Timestamp;

import DAO.*;

public class TarefaRota extends GenericModel{

	private String observacao;
	private Timestamp data_inicio;
	private Timestamp data_fim;
    private Integer id_rota;
    
    static RotaDAO rotaDAO = new RotaDAO();

    public TarefaRota(String observacao, Timestamp data_inicio, Timestamp data_fim, Integer id_rota) {
        this.observacao = observacao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.id_rota = id_rota;
    }
    
    public TarefaRota(Integer id, String observacao, Timestamp data_inicio, Timestamp data_fim, Integer id_rota) {
    	this.observacao = observacao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.id_rota = id_rota;
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

    public int getIdRota() {
    	return id_rota;
    }
    
    @Override
    public String toString() {
        return "TarefaRota {" +
                "id='" + this.getId() + "\'" +
                ", observacao='" + observacao + "\'" +
                ", data_inicio='" + data_inicio + "\'" +
                ", data_fim='" + data_fim + "\'" +
                ", id_rota='" + rotaDAO.selectRota(id_rota) + "\'" +
                '}';
    }
	
}

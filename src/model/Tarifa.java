package model;

import DAO.*;

public class Tarifa extends GenericModel{

	private String taxa;
	private String lei;
	private String data_inicio;
	private String data_fim;
	private String aliquota_ICMS;
	private Classe id_classe;
	
	static ClasseDAO classeDAO = new ClasseDAO();
	
	public Tarifa(String taxa, String lei, String data_inicio, String data_fim, String aliquota_ICMS, Classe id_classe) {
        this.taxa = taxa;
        this.lei = lei;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.aliquota_ICMS = aliquota_ICMS;
        this.id_classe = id_classe;
    }
    
    public Tarifa(Integer id, String taxa, String lei, String data_inicio, String data_fim, String aliquota_ICMS, Classe id_classe) {
    	this.taxa = taxa;
        this.lei = lei;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.aliquota_ICMS = aliquota_ICMS;
        this.id_classe = id_classe;
        super.setId(id);
    }
	
    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }
    
    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }
    
    public String getDataInicio() {
        return data_inicio;
    }

    public void setDataInicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }
    
    public String getDataFim() {
        return data_fim;
    }

    public void setDataFim(String data_fim) {
        this.data_fim = data_fim;
    }
    
    public String getAliquotaICMS() {
    	return aliquota_ICMS;
    }
    
    public void setAliquotaICMS(String aliquota_ICMS) {
        this.aliquota_ICMS = aliquota_ICMS;
    }
    
    public int getIdClasse() {
    	return id_classe.getId();
    }
    
    @Override
    public String toString() {
        return "Tarifa {" +
                "id='" + this.getId() + "\'" +
                ", taxa='" + taxa + "\'" +
                ", lei='" + lei + "\'" +
                ", data_inicio='" + data_inicio + "\'" +
                ", data_fim='" + data_fim + "\'" +
                ", aliquota_ICMS='" + aliquota_ICMS + "\'" +
                ", id_classe='" + getIdClasse() + "\'" +
                '}';
    }
	
}

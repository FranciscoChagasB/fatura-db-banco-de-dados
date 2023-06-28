package model;

import DAO.TarifaDAO;
import DAO.MedicaoDAO;

public class Cobranca extends GenericModel {
	
	private String mes_referencia;
    private String ano_referencia;
    private Tarifa tarifaId;
    private Medicao medicaoId;

    static TarifaDAO tarifaDAO = new TarifaDAO();
    static MedicaoDAO medicaoDAO = new MedicaoDAO();
    
    public Cobranca(String mesReferencia, String anoReferencia, Tarifa tarifaId, Medicao medicaoId) {
        this.mes_referencia = mesReferencia;
        this.ano_referencia = anoReferencia;
        this.tarifaId = tarifaId;
        this.medicaoId = medicaoId;
    }
    public Cobranca(int id, String mesReferencia, String anoReferencia, Tarifa tarifaId, Medicao medicaoId) {
        this.mes_referencia = mesReferencia;
        this.ano_referencia = anoReferencia;
        this.tarifaId = tarifaId;
        this.medicaoId = medicaoId;
        super.setId(id);
    }

    public String getMesReferencia() {
        return mes_referencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mes_referencia = mesReferencia;
    }

    public String getAnoReferencia() {
        return ano_referencia;
    }

    public void setAnoReferencia(String anoReferencia) {
        this.ano_referencia = anoReferencia;
    }

    public int getTarifaModel() {
        return tarifaId.getId();
    }


    public int getMedicaoModel() {
        return medicaoId.getId();
    }

    @Override
    public String toString() {
        return "Cobranca{" +
                "id='" + this.getId() + '\'' +
                ", mes_referencia='" + getMesReferencia() + '\'' +
                ", ano_referencia='" + getAnoReferencia() + '\'' +
                ", id_tarifa='" + getTarifaModel() + '\'' +
                ", id_medicao='" + getMedicaoModel() + '\'' +
                '}';
    }
}
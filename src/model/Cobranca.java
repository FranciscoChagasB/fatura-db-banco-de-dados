package model;

public class Cobranca extends GenericModel {
    private String mes_referencia;
    private String ano_referencia;
    private Integer tarifa_id;
    private Integer medicao_id;

    public Cobranca(String mes_referencia, String ano_referencia, Integer tarifa_id, Integer medicao_id) {
        this.mes_referencia = mes_referencia;
        this.ano_referencia = ano_referencia;
        this.tarifa_id = tarifa_id;
        this.medicao_id = medicao_id;
    }
    
    public Cobranca(Integer id, String mes_referencia, String ano_referencia, Integer tarifa_id, Integer medicao_id) {
        this.mes_referencia = mes_referencia;
        this.ano_referencia = ano_referencia;
        this.tarifa_id = tarifa_id;
        this.medicao_id = medicao_id;
        super.setId(id);
    }

    public String getMesReferencia() {
        return mes_referencia;
    }

    public void setMesReferencia(String mes_referencia) {
        this.mes_referencia = mes_referencia;
    }

    public String getAnoReferencia() {
        return ano_referencia;
    }

    public void setAnoReferencia(String ano_referencia) {
        this.ano_referencia = ano_referencia;
    }

    public Integer getTarifaId() {
        return tarifa_id;
    }

    public void setTarifaId(Integer tarifa_id) {
        this.tarifa_id = tarifa_id;
    }

    public Integer getMedicaoId() {
        return medicao_id;
    }

    public void setMedicaoId(Integer medicao_id) {
        this.medicao_id = medicao_id;
    }

    @Override
    public String toString() {
        return "Cobranca{" +
                "id='" + this.getId() + '\'' +
                ", mes_referencia='" + mes_referencia + '\'' +
                ", ano_referencia='" + ano_referencia + '\'' +
                ", tarifa_id='" + tarifa_id + '\'' +
                ", medicao_id='" + medicao_id + '\'' +
                '}';
    }
}
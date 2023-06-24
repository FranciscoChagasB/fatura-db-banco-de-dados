package model;
import DAO.*;

public class Classe extends GenericModel {
    private String descricao;
    private Integer id_tipo_fase;
    
    static TipoFaseDAO tipoFaseDAO = new TipoFaseDAO();
    

    public Classe(String descricao, Integer id_tipo_fase) {
        this.descricao = descricao;
        this.id_tipo_fase = id_tipo_fase;
    }
    
    public Classe(Integer id, String descricao, Integer id_tipo_fase) {
        this.descricao = descricao;
        this.id_tipo_fase = id_tipo_fase;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdTipoFase() {
    	return id_tipo_fase;
    }
    
    
    @Override
    public String toString() {
        return "Classe {" +
                "id='" + this.getId() + "\'" +
                ", descricao='" + descricao + "\'" +
                ", id_tipo_fase='" + tipoFaseDAO.selectTipoFase(id_tipo_fase) + "\'" +
                '}';
    }
}
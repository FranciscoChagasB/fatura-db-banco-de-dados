package model;

public class Classe extends GenericModel {
    private String descricao;
    private TipoFase id_tipo_fase;
    

    public Classe(String descricao, TipoFase id_tipo_fase) {
        this.descricao = descricao;
        this.id_tipo_fase = id_tipo_fase;
    }
    
    public Classe(Integer id, String descricao, TipoFase id_tipo_fase) {
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
    	return id_tipo_fase.getId();
    }
    
    @Override
    public String toString() {
        return "Classe {" +
                "id='" + this.getId() + "\'" +
                ", descricao='" + getDescricao() + "\'" +
                ", id_tipo_fase='" + getIdTipoFase() + "\'" +
                '}';
    }
}
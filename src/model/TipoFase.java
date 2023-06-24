package model;

public class TipoFase extends GenericModel {
	
    private String descricao;

    public TipoFase(String descricao) {
        this.descricao = descricao;
    }

    public TipoFase(Integer id, String descricao) {
        this.descricao = descricao;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoFase {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                '}';
    }
}

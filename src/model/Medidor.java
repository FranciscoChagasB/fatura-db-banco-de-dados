package model;

public class Medidor extends GenericModel{

	private String descricao;
    private Rota rotaId;
    private Poste posteId;

    public Medidor(String descricao, Rota rotaId, Poste posteId) {
        this.descricao = descricao;
        this.rotaId = rotaId;
        this.posteId = posteId;
    }
    public Medidor(int id, String descricao, Rota rotaId, Poste posteId) {
        this.descricao = descricao;
        this.rotaId = rotaId;
        this.posteId = posteId;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRotaId() {
        return rotaId.getId();
    }

    public int getPosteId() {
        return posteId.getId();
    }

    @Override
    public String toString() {
        return "Medidor {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + getDescricao() + "\'" +
                "id_rota='" + getRotaId() + "\'" +
                "id_poste='" + getPosteId() + "\'" +
                '}';
    }
	
}

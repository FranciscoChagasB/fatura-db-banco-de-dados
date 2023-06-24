package model;

public class TipoPessoa extends GenericModel{
	
	private String descricao;
	
	public TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public TipoPessoa(Integer id, String descricao) {
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
        return "TipoPessoa {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                '}';
    }
	
	
}

package model;

public class RetornaDados extends GenericModel{

	private String poste;
    private String nome;
    private String cnpj;
    private String classe;
    private String tipoFase;
    private String cpf;
	
	public RetornaDados(int id, String cpf, String poste, String nome, String cnpj, String classe, String tipoFase) {
		this.poste = poste;
        this.nome = nome;
        this.cnpj = cnpj;
        this.classe = classe;
        this.tipoFase = tipoFase;
        this.cpf = cpf;
		super.setId(id);
	}
	
	public String getPoste() {
        return poste;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getClasse() {
        return classe;
    }

    public String getTipoFase() {
        return tipoFase;
    }
	
    @Override
    public String toString() {
        return "DataClien{ \n" +
                " \tposte=" + getPoste() + "\n" +
                " \tnome=" + getNome() + "\n" +
                " \tcnpj=" + getCnpj() + "\n" +
                " \tclasse=" + getClasse() + "\n" +
                " \ttipoFase=" + getTipoFase() + "\n" +
                " \tcpf=" + getCpf() + "\n" +
                '}';
    }
	
}

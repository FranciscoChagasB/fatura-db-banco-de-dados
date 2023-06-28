package util;

import DAO.*;
import model.*;

public class Program {
	
	static TipoPessoaDAO tipo_pessoaDAO = new TipoPessoaDAO();
    static PessoaDAO pessoaDAO = new PessoaDAO();
    static RotaDAO rotaDAO = new RotaDAO();
    static TarefaRotaDAO tarefaRota = new TarefaRotaDAO();
    static TimeRotaDAO timeRotaDAO = new TimeRotaDAO();
    static ClienteDAO clienteDAO = new ClienteDAO();
    static FuncionarioDAO funcionario = new FuncionarioDAO();
    static RetornaDadosDAO retornaDadosDAO = new RetornaDadosDAO();
	
	static TipoFaseDAO tipoFaseDAO = new TipoFaseDAO();

	public static void main(String[] args) {

		TipoFase tipoFase = new TipoFase("Trifásico");
		tipoFaseDAO.insertTipoFase(tipoFase);
        System.out.println(tipoFase.getDescricao());
        
        TipoPessoa tipoPessoa = new TipoPessoa("pessoa fisica");
        Pessoa pessoa = new Pessoa(1, "francisco", "04231564789", tipoPessoa);
        Cliente cliente = new Cliente("05054185", "1415129818", pessoa);
        System.out.println(cliente);
		
		RetornaDados retornaDados = new RetornaDados(1, "04232654896", "021457", "Joao", "", "classe 1", "monofásico");
		System.out.println(retornaDados);
		
        
	}

}

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

	public static void main(String[] args) throws Exception {

		TipoFase tipoFase = new TipoFase(1, "Trifásico");
		tipoFaseDAO.updateTipoFase(tipoFase);
        System.out.println(tipoFase.getDescricao());
        
        TipoPessoa tipoPessoa = new TipoPessoa("pessoa fisica");
        Pessoa pessoa = new Pessoa(1, "francisco", "04231564789", tipoPessoa);
        Cliente cliente = new Cliente(1, "05054185", "1415129818", pessoa);
		clienteDAO.selectClienteById(1);
        System.out.println(cliente);
		
		RetornaDados retornaDados = new RetornaDados(1, "12487596231", "014234", "Maria", null, "classe B", "monofásico");
		retornaDadosDAO.selectRetornaDadosById(1);
		System.out.println(retornaDados);
		
        
	}

}

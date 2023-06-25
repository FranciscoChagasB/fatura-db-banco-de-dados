package model;

import DAO.*;

public class TimeRota extends GenericModel{

	private Integer id_funcionario;
	private Integer id_tarefa_rota;
	
	static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	static TarefaRotaDAO tarefaRotaDAO = new TarefaRotaDAO();
	
	public TimeRota(Integer id_funcionario, Integer id_tarefa_rota) {
        this.id_funcionario = id_funcionario;
        this.id_tarefa_rota = id_tarefa_rota;
    }
    
    public TimeRota(Integer id, Integer id_funcionario, Integer id_tarefa_rota) {
    	this.id_funcionario = id_funcionario;
        this.id_tarefa_rota = id_tarefa_rota;
        super.setId(id);
    }
	
    public int getIdFuncionario() {
    	return id_funcionario;
    }
    
    public int getIdTarefaRota() {
    	return id_tarefa_rota;
    }
    
    @Override
    public String toString() {
        return "TimeRota {" +
                "id='" + this.getId() + "\'" +
                ", id_funcionario='" + funcionarioDAO.selectFuncionario(id_funcionario) + "\'" +
                ", id_tarefa_rota='" + tarefaRotaDAO.selectTarefaRota(id_tarefa_rota) + "\'" +
                '}';
    }
    
}

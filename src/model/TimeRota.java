package model;

import DAO.*;

public class TimeRota extends GenericModel{

	private Funcionario funcionarioId;
    private TarefaRota tarefaRotaId;

    static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    static TarefaRotaDAO tarefaRotaDAO = new TarefaRotaDAO();
    
    public TimeRota(Funcionario funcionarioId, TarefaRota tarefaRotaId) {
        this.funcionarioId = funcionarioId;
        this.tarefaRotaId = tarefaRotaId;
    }

    public TimeRota(Integer id, Funcionario funcionario_id, TarefaRota tarefa_rota_id) {
        this.funcionarioId = funcionario_id;
        this.tarefaRotaId = tarefa_rota_id;
        super.setId(id);
    }

    public Integer getFuncionarioId() {
        return funcionarioId.getId();
    }

    public Integer getTarefaRotaId() {
        return tarefaRotaId.getId();
    }
    
    @Override
    public String toString() {
        return "TimeRota {" +
                "id='" + this.getId() + "\'" +
                ", id_funcionario='" + getFuncionarioId() + "\'" +
                ", id_tarefa_rota='" + getTarefaRotaId() + "\'" +
                '}';
    }
    
}

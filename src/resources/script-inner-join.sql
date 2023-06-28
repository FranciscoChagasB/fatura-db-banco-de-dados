SELECT * FROM tipo_fase
INNER JOIN classe ON classe.id_tipo_fase = tipo_fase.id
INNER JOIN tarifa ON tarifa.id_classe = classe.id
INNER JOIN contrato ON contrato.id_classe = classe.id
INNER JOIN medidor ON medidor.id = contrato.id_medidor
INNER JOIN rota ON rota.id = medidor.id_rota
INNER JOIN poste ON poste.id = medidor.id_poste
INNER JOIN cliente ON cliente.id = contrato.id_cliente
INNER JOIN pessoa ON pessoa.id = cliente.id_pessoa
INNER JOIN tarefa_rota ON tarefa_rota.id_rota = rota.id

WHERE pessoa.id = 1;
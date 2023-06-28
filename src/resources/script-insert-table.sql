--tabela tipo_fase
INSERT INTO tipo_fase (descricao) VALUES ('Fase 1');
INSERT INTO tipo_fase (descricao) VALUES ('Fase 2');
INSERT INTO tipo_fase (descricao) VALUES ('Fase 3');

--tabela classe
INSERT INTO classe (descricao, id_tipo_fase) VALUES ('Classe A', 1);
INSERT INTO classe (descricao, id_tipo_fase) VALUES ('Classe B', 2);
INSERT INTO classe (descricao, id_tipo_fase) VALUES ('Classe C', 3);

--tabela tarifa
INSERT INTO tarifa (taxa, lei, data_inicio, data_fim, aliquota_icms, id_classe)
VALUES ('10%', 'Lei 123', '2023-01-01', '2023-12-31', '12%', 1);
INSERT INTO tarifa (taxa, lei, data_inicio, data_fim, aliquota_icms, id_classe)
VALUES ('12%', 'Lei 456', '2023-01-01', '2023-12-31', '15%', 2);

--tabela tipo_pessoa
INSERT INTO tipo_pessoa (descricao) VALUES ('F¨ªsica');
INSERT INTO tipo_pessoa (descricao) VALUES ('Jur¨ªdica');

--tabela pessoa
INSERT INTO pessoa (nome, cpf, cnpj, id_tipo_pessoa)
VALUES ('Jo?o', '12345678901', NULL, 1);
INSERT INTO pessoa (nome, cpf, cnpj, id_tipo_pessoa)
VALUES ('Empresa ABC', NULL, '12345678901234', 2);

--tabela funcionario
INSERT INTO funcionario (codigo_funcionario, id_pessoa)
VALUES ('123', 1);

--tabela cliente
INSERT INTO cliente (num_documento, num_cliente, id_pessoa)
VALUES ('987654321', 'C001', 2);

--tabela rota
INSERT INTO rota (descricao) VALUES ('Rota 1');
INSERT INTO rota (descricao) VALUES ('Rota 2');

--tabela poste
INSERT INTO poste (latitude, longitude, codigo, observacao)
VALUES ('123.456', '789.012', 'P001', 'Observa??o 1');
INSERT INTO poste (latitude, longitude, codigo, observacao)
VALUES ('345.678', '901.234', 'P002', 'Observa??o 2');

--tabela medidor
INSERT INTO medidor (descricao, id_rota, id_poste)
VALUES ('Medidor 1', 1, 1);
INSERT INTO medidor (descricao, id_rota, id_poste)
VALUES ('Medidor 2', 2, 2);

--tabela tarefa_rota
INSERT INTO tarefa_rota (observacao, data_inicio, data_fim, id_rota)
VALUES ('Observa??o 1', '2023-01-01', '2023-01-02', 1);
INSERT INTO tarefa_rota (observacao, data_inicio, data_fim, id_rota)
VALUES ('Observa??o 2', '2023-01-01', '2023-01-02', 2);

--tabela time_rota
INSERT INTO time_rota (id_funcionario, id_tarefa_rota)
VALUES (1, 1);
INSERT INTO time_rota (id_funcionario, id_tarefa_rota)
VALUES (1, 2);

--tabela medicao
INSERT INTO medicao (mes, ano, data_medicao, consumo, id_medidor, id_time_rota)
VALUES ('Janeiro', '2023', '2023-01-01', '100 kWh', 1, 1);
INSERT INTO medicao (mes, ano, data_medicao, consumo, id_medidor, id_time_rota)
VALUES ('Fevereiro', '2023', '2023-02-01', '150 kWh', 2, 2);

--tabela cobranca
INSERT INTO cobranca (mes_referencia, ano_referencia, id_tarifa, id_medicao)
VALUES ('Janeiro', '2023', 1, 1);
INSERT INTO cobranca (mes_referencia, ano_referencia, id_tarifa, id_medicao)
VALUES ('Fevereiro', '2023', 2, 2);

--tabela contrato
INSERT INTO contrato (descricao, data_inicio, data_criacao, id_medidor, id_classe, id_cliente)
VALUES ('Contrato 1', '2023-01-01', '2023-01-01', 1, 1, 1);
INSERT INTO contrato (descricao, data_inicio, data_criacao, id_medidor, id_classe, id_cliente)
VALUES ('Contrato 2', '2023-01-01', '2023-01-01', 2, 2, 1);

CREATE TABLE tipo_fase(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE classe(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45),
    id_tipo_fase INT REFERENCES tipo_fase(id)
);

CREATE TABLE tarifa(
    id SERIAL PRIMARY KEY,
    taxa VARCHAR(45),
    lei VARCHAR(45) not null,
    data_inicio VARCHAR(45) not null,
    data_fim VARCHAR(45) not null,
	aliquota_icms VARCHAR(45) not null,
	id_classe INT REFERENCES classe(id)
);

CREATE TABLE tipo_pessoa(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE pessoa(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(45) not null,
    cpf VARCHAR(45) not null,
    cnpj VARCHAR(45),
    id_tipo_pessoa INT REFERENCES tipo_pessoa(id)
);

CREATE TABLE funcionario(
    id SERIAL PRIMARY KEY,
    codigo_funcionario VARCHAR(45) not null UNIQUE ,
    id_pessoa INT REFERENCES pessoa(id) UNIQUE
);

CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    num_documento VARCHAR(45) not null unique,
    num_cliente VARCHAR(45) not null unique,
    id_pessoa INT REFERENCES  pessoa(id)
);


CREATE TABLE rota(
  id SERIAL PRIMARY KEY,
  descricao VARCHAR(45)
);


CREATE TABLE poste(
  id SERIAL PRIMARY KEY,
  latitude VARCHAR(45),
  longitude VARCHAR(45),
  codigo VARCHAR(45),
  observacao VARCHAR(45)
);

CREATE  TABLE  medidor(
    id SERIAL PRIMARY KEY,
    descricao  VARCHAR(45),
    id_rota INT REFERENCES rota(id),
    id_poste INT REFERENCES poste(id)
);


CREATE TABLE tarefa_rota(
    id SERIAL PRIMARY KEY,
    observacao VARCHAR(45),
    data_inicio TIMESTAMP,
    data_fim TIMESTAMP,
    id_rota INT REFERENCES rota(id)
);

CREATE TABLE time_rota (
    id SERIAL PRIMARY KEY,
    id_funcionario INT REFERENCES funcionario(id),
    id_tarefa_rota INT REFERENCES tarefa_rota(id)
);

CREATE TABLE medicao(
    id SERIAL PRIMARY KEY,
    mes VARCHAR(45),
    ano VARCHAR(45),
    data_medicao TIMESTAMP,
    consumo VARCHAR(45),
    id_medidor INT REFERENCES medidor(id),
    id_time_rota INT REFERENCES  time_rota(id)
);

CREATE TABLE cobranca(
    id SERIAL PRIMARY KEY,
    mes_referencia VARCHAR(45),
    ano_referencia VARCHAR(45),
    id_tarifa INT REFERENCES tarifa(id),
    id_medicao INT REFERENCES medicao(id)
);

CREATE TABLE contrato (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45),
    data_inicio TIMESTAMP,
    data_criacao TIMESTAMP,
    id_medidor INT REFERENCES medidor(id),
    id_classe INT REFERENCES classe(id),
    id_cliente INT REFERENCES cliente(id)
)
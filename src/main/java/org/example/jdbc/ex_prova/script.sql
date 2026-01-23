CREATE
DATABASE escola_db;

CREATE TABLE alunos
(
    id         SERIAL PRIMARY KEY,
    nome       VARCHAR(100) NOT NULL,
    cpf_objeto BYTEA        NOT NULL,
    endereco   VARCHAR(255),
    turma      VARCHAR(50)
);

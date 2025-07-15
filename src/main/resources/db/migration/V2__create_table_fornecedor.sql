DROP TABLE fornecedor;

CREATE SEQUENCE IF NOT EXISTS fornecedor_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS fornecedor (
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('fornecedor_id_seq'),
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) UNIQUE NOT NULL,
    email VARCHAR(150) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    ativo BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    deleted_tmsp TIMESTAMP WITHOUT TIME ZONE
);


INSERT INTO fornecedor (id, nome, cnpj, email, telefone, ativo, created_at, updated_at, deleted_tmsp) VALUES (1, 'fornecedor 1', '08.654.442/0001-63', 'teste@teste.com.br', '11912345678', true, NULL, NULL, NULL);
INSERT INTO fornecedor (id, nome, cnpj, email, telefone, ativo, created_at, updated_at, deleted_tmsp) VALUES (2, 'fornecedor 2', '98.397.793/0001-29', 'teste@teste.com.br', '11912345678', true, NULL, NULL, NULL);
INSERT INTO fornecedor (id, nome, cnpj, email, telefone, ativo, created_at, updated_at, deleted_tmsp) VALUES (3, 'fornecedor 3', '47.427.369/0001-49', 'teste@teste.com.br', '11912345678', true, NULL, NULL, NULL);

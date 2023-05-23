CREATE TABLE ocorrencia (
    id BIGINT NOT NULL AUTO_INCREMENT,
    entrega BIGINT NOT NULL,
    descricao TEXT NOT NULL,
    data_registro DATETIME NOT NULL,

    PRIMARY KEY (id)
);

ALTER TABLE ocorrencia CONSTRAINT fk_ocorrencia_entrega
FOREIGN KEY (entrega_id) REFERENCES entrega (id);
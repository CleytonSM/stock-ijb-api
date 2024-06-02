CREATE TABLE tb_doador (
                           id INT AUTO_INCREMENT,
                           nome VARCHAR(45),
                           cpf VARCHAR(11),
                           telefone VARCHAR(11),
                           CONSTRAINT pk_tb_doador_id PRIMARY KEY (id)
);

CREATE TABLE tb_doacao (
                           id INT AUTO_INCREMENT,
                           id_doador INT,
                           ds_doacao VARCHAR(255),
                           qt_doacao BIGINT,
                           CONSTRAINT pk_tb_doacao_id PRIMARY KEY (id),
                           CONSTRAINT fk_tb_doacao_id_doador FOREIGN KEY (id_doador)
                               REFERENCES tb_doador (id)
                               ON DELETE CASCADE
                               ON UPDATE CASCADE
);
CREATE TABLE tb_produto_outlet (
                           id INT AUTO_INCREMENT,
                           id_doacao INT,
                           nm_produto_outlet VARCHAR(60),
                           ds_produto_outlet VARCHAR(100),
                           CONSTRAINT pk_tb_produto_outlet_id PRIMARY KEY (id),
                           CONSTRAINT fk_tb_produto_outlet_id_doacao FOREIGN KEY (id_doacao)
                               REFERENCES tb_doacao (id)
);
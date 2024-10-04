create table conserto(
    id BIGINT NOT NULL AUTO_INCREMENT,
    data_entrada VARCHAR(10),
    data_saida VARCHAR(10),
    marca VARCHAR(100),
    modelo VARCHAR(100),
    ano INT,
    nome VARCHAR(100),
    anos_experiencia INT,

    PRIMARY KEY(id)
);
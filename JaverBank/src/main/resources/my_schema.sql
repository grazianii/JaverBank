CREATE TABLE cliente (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR (100),
    cpf VARCHAR (11),
    telefone VARCHAR (11),
    correntista BOOLEAN
);

CREATE TABLE contaCorrente (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	score_credito NUMERIC (20, 2),
    saldo_cc NUMERIC (20, 2),
    cliente_id INTEGER REFERENCES cliente (id)
);

CREATE TABLE usuario (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR (100),
    senha VARCHAR (50),
    nome VARCHAR (100)
)

CREATE TABLE grupo (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR (50)
)

CREATE TABLE usuariogrupo (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    usuario_id INTEGER REFERENCES usuario (id),
    grupo_id INTEGER REFERENCES grupo (id)
)

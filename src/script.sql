-- As tabelas são criadas na inicialização, só é preciso criar o schema e colocar a conexão dele
-- na classe de conexão do banco de dados. O admin também é criado programaticamente.

CREATE DATABASE IF NOT EXISTS prova_dsw;

USE prova_dsw;

CREATE TABLE IF NOT EXISTS usuario (
	email VARCHAR(50) PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	senha VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS pedido (
	id_pedido INT PRIMARY KEY,
	nome_cliente VARCHAR(100) NOT NULL,
	endereco_entrega VARCHAR(200) NOT NULL,
	valor DECIMAL(10, 2) NOT NULL,
	descricao VARCHAR(300),
	email_usuario VARCHAR(50) NOT NULL,
	FOREIGN KEY (email_usuario) REFERENCES usuario(email)
	ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO usuario (email, nome, senha) VALUES ('admin@admin', 'admin', 'admin');
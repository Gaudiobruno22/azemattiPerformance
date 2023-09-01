-- Carga de Dados Tabela T_SER_TPSERVICO
INSERT INTO T_SER_TPSERVICO (SER_TPSERVICO_DESCRICAO, SER_TPSERVICO_MAPA, SER_TPSERVICO_DOWNPIPE, SER_TPSERVICO_TROCA_TURBINA, SER_TPSERVICO_MECANICA)
VALUES ('Stage 01', 'S', 'N', 'N', 'N'),
	   ('Stage 02', 'S', 'S', 'N', 'S'),
	   ('Stage 03', 'S', 'S', 'S', 'S');


INSERT INTO T_USU_SOLCADASTRO (USU_USUARIO_NOME, USU_USUARIO_CPF, USU_USUARIO_CIDADE, USU_USUARIO_ESTADO, USU_USUARIO_EMAIL, USU_USUARIO_TELEFONE, USU_USUARIO_VEICULO, USU_USUARIO_SERVICO)
VALUES ('Bruno Gaudio', '43658588829', 'São Paulo', 'SP', 'bruno@gmail.com', '11999171112', 'Golf GTI', 'Stage 02');

INSERT INTO T_USU_SOLCADASTRO (USU_USUARIO_NOME, USU_USUARIO_CPF, USU_USUARIO_CIDADE, USU_USUARIO_ESTADO, USU_USUARIO_EMAIL, USU_USUARIO_TELEFONE, USU_USUARIO_VEICULO, USU_USUARIO_SERVICO)
VALUES ('Paulo Lopes', '12345678910', 'São Paulo', 'SP', 'paulo@gmail.com', '11456789236', 'Jetta 2.0 Tfsi', 'Stage 02');
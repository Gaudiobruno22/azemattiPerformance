-- Inserir dados na tabela T_USU_SOLCADASTRO
INSERT INTO T_USU_SOLCADASTRO (USU_USUARIO_NOME, 
							   USU_USUARIO_CPF,
							   USU_USUARIO_CIDADE, 
							   USU_USUARIO_ESTADO, 
							   USU_USUARIO_EMAIL, 
							   USU_USUARIO_TELEFONE, 
							   USU_USUARIO_VEICULO, 
							   USU_USUARIO_SERVICO)
VALUES
    ('João Bernardo', '12345678901', 'São Paulo', 'SP', 'joao@email.com', '(11) 1234-5678', 'Jetta 2.0 Tsi', 'Stage 02'),
    ('Maria Souza', '98765432101', 'Rio de Janeiro', 'RJ', 'maria@email.com', '(21) 9876-5432', 'T-Cross 1.4 Tfsi', 'Stage 01'),
	('Carlos Lopes', '12345465689', 'São Paulo', 'SP', 'carlos@email.com', '(21) 9876-5432', 'Golf GTI', 'Stage 03'),
	('Bruno Gaudio', '45478799962', 'São Paulo', 'SP', 'bruno@gmail.com', '(11) 94544-5215', 'BMW M240i', 'Stage 02')  
;

-- Inserir dados na tabela T_SER_SERVICO
INSERT INTO T_SER_SERVICO (SER_SERVICO_COD, 
						   SER_SERVICO_DESCRICAO, 
						   USU_USUARIO_CODIGO, 
						   USU_USUARIO_CPF, 
						   SER_SERVICO_PAGO, 
						   SER_SERVICO_VALOR, 
						   SER_SERVICO_DESCONTO, 
						   SER_SERVICO_FINALIZADO)
VALUES
    ('01', 'Stage 01', 1, NULL, 'S', 100.00, 0.10, 'S'),
    ('02', 'Stage 02', NULL, '98765432101', 'N', 50.00, 0.05, 'N'),
	('03', 'Stage 03', NULL, '98765432101', 'N', 50.00, 0.05, 'N')
;

-- Inserir dados na tabela T_CAD_CADASTROS
INSERT INTO T_CAD_CADASTROS (USU_USUARIO_CODIGO, VEICULO, SER_SERVICO_COD)
VALUES
    (1, 'Jetta 2.0 Tsi', '01'),
    (2, 'T-Cross 1.4 Tfsi', '02'),
	(3, 'Golf GTI', '03'),
	(4, 'BMW M240i', '02')
;
-- Inserção de dados na tabela "usuario"
INSERT INTO usuario (aceita_email, aparelho_utilizado, assina_streaming, busca_avaliacao, cep, data_nasc, email, genero_preferido, logado, nome, qtd_frequencia, senha, sexo)
VALUES
 (TRUE, 'Celular', TRUE, FALSE, '12345', '2000-01-01', 'john.doe@gmail.com', 'Ação', FALSE, 'John Doe', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino'),
 (FALSE, 'Celular', TRUE, FALSE, '12345', '2000-01-01', 'luiz@vove.com', 'rock', FALSE, 'Luize', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino'),
 (TRUE, 'Tablet', FALSE, TRUE, '54321', '1995-07-15', 'ana@gmail.com', 'Comédia', FALSE, 'Ana Silva', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Feminino'),
 (FALSE, 'Computador', FALSE, FALSE, '98765', '1988-03-10', 'carlos@gmail.com', 'Ação', FALSE, 'Carlos Santos', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino');

INSERT INTO votacao (avaliacao, tmdb_id_filme, usuario_id) VALUES (4, 299054, 2);
INSERT INTO votacao (avaliacao, tmdb_id_filme, usuario_id) VALUES (3, 968051, 2);
INSERT INTO votacao (avaliacao, tmdb_id_filme, usuario_id) VALUES (3, 1008042, 2);
INSERT INTO votacao (avaliacao, tmdb_id_filme, usuario_id) VALUES (4, 1008042, 3);


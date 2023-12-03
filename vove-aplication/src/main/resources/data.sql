-- Inserção de dados na tabela "usuario"
INSERT INTO usuario (aceita_email, aparelho_utilizado, assina_streaming, busca_avaliacao, cep, data_nasc, email, genero_preferido, logado, nome, qtd_frequencia, senha, sexo)
VALUES
 (TRUE, 'Celular', TRUE, FALSE, '12345', '2000-01-01', 'john.doe@gmail.com', 'Ação', FALSE, 'John Doe', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino'),
 (FALSE, 'Celular', TRUE, FALSE, '12345', '2000-01-01', 'luiz@vove.com', 'rock', FALSE, 'Luize', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino'),
 (TRUE, 'Tablet', FALSE, TRUE, '54321', '1995-07-15', 'ana@gmail.com', 'Comédia', FALSE, 'Ana Silva', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Feminino'),
 (FALSE, 'Computador', FALSE, FALSE, '98765', '1988-03-10', 'carlos@gmail.com', 'Ação', FALSE, 'Carlos Santos', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino');
INSERT INTO comentario (descricao, momento_comentario, tmdb_id_filme, spoiler, avaliacao, usuario_id)
VALUES
    ('Bom filme!', CURRENT_TIMESTAMP, 901362, FALSE, 5, 2),
    ('Interessante.', CURRENT_TIMESTAMP, 968051, FALSE, 3, 2),
    ('Gostei muito!', CURRENT_TIMESTAMP, 1008042, FALSE, 3, 2),
    ('Recomendo!', CURRENT_TIMESTAMP, 1008042, FALSE, 4, 3);


INSERT INTO comentario (descricao, momento_comentario, tmdb_id_filme, usuario_id, spoiler, avaliacao)
VALUES
    ('Ótimo filme! Recomendo a todos.', '2023-08-27 15:30:00', 507089, 2, FALSE, 4),
    ('O filme teve alguns momentos interessantes, mas o final me deixou um pouco decepcionado.', '2023-08-27 16:45:00', 507089, 2, FALSE, 3),
    ('Sem palavras, esse filme é simplesmente incrível e ele morre e é uma boneca!', '2023-08-27 18:20:00', 507089, 3, TRUE, 5);

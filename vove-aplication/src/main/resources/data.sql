-- Inserção de dados na tabela "usuario"
INSERT INTO usuario (aceita_email, aparelho_utilizado, assina_streaming, busca_avaliacao, cep, data_nasc, email, genero_preferido, logado, nome, qtd_frequencia, senha, sexo)
VALUES
 (TRUE, 'Celular', TRUE, FALSE, '12345', '2000-01-01', 'john.doe@gmail.com', 'Ação', FALSE, 'John Doe', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino'),
 (FALSE, 'Celular', TRUE, FALSE, '12345', '2000-01-01', 'luiz@vove.com', 'rock', FALSE, 'Luize', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino'),
 (TRUE, 'Tablet', FALSE, TRUE, '54321', '1995-07-15', 'ana@gmail.com', 'Comédia', FALSE, 'Ana Silva', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Feminino'),
 (FALSE, 'Computador', FALSE, FALSE, '98765', '1988-03-10', 'carlos@gmail.com', 'Ação', FALSE, 'Carlos Santos', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino');

-- Inserção de dados na tabela "comentario"
INSERT INTO comentario (descricao, momento_comentario, tmdb_id_filme, fk_usuario)
VALUES
    ('Ótimo filme! Recomendo a todos.', '2023-08-27 15:30:00', 569094, 2),
    ('O filme teve alguns momentos interessantes, mas o final me deixou um pouco decepcionado.', '2023-08-27 16:45:00', 667538, 2),
    ('Sem palavras, esse filme é simplesmente incrível e ele morre e é uma boneca!', '2023-08-27 18:20:00', 346698, 3);

-- Inserção de dados na tabela "lista"
INSERT INTO lista (nome_da_lista, fk_usuario)
VALUES
    ('Favoritos', 1),
    ('Assistir Mais Tarde', 1),
    ('Comédias Favoritas', 3),
    ('Ação e Aventura', 4),
    ('Lista A', 2),
    ('Lista B', 2),
    ('Romances Queridos', 3),
    ('Suspense e Mistério', 3);

-- Inserção de dados na tabela "lista_tabela"
INSERT INTO lista_tabela (tmdb_id_filme, fk_lista, fk_usuario)
VALUES
    (346698, 5, 2),
    (872585, 5, 2);

-- Inserção de dados na tabela "votacao"
INSERT INTO votacao (avaliacao, tmdb_id_filme, fk_usuario)
VALUES
    (5, 346698, 2),
    (4, 346698, 3);

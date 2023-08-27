INSERT INTO usuario (ID, ACEITA_EMAIL, APARELHO_UTILIZADO, ASSINA_STREAMING, BUSCA_AVALIACAO, CEP, DATA_NASC, EMAIL,
 GENERO_PREFERIDO, LOGADO, NOME, QTD_FREQUENCIA, SENHA, SEXO)
 VALUES
 (1, TRUE, 'Celular', TRUE, FALSE, 12345, '2000-01-01', 'john.doe@gmail.com', 'Ação', FALSE, 'John Doe', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino'),
 (2, FALSE, 'Celular', TRUE, FALSE, 12345, '2000-01-01', 'luiz@vove.com', 'rock', FALSE, 'Luize', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino'),
 (3, TRUE, 'Tablet', FALSE, TRUE, 54321, '1995-07-15', 'ana@gmail.com', 'Comédia', FALSE, 'Ana Silva', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Feminino'),
 (4, FALSE, 'Computador', FALSE, FALSE, 98765, '1988-03-10', 'carlos@gmail.com', 'Ação', FALSE, 'Carlos Santos', 10, '$2a$10$PU4XokmGPNejARzCnblVD.dWzdX3eCvb5pY6.5qh4YYqSNvirQKsq', 'Masculino');

INSERT INTO comentario (ID, AVALIACAO, DESCRICAO, MOMENTO_COMENTARIO, SPOILER, TMDB_ID_FILME, USUARIO_ID)
VALUES
    (1, 4, 'Ótimo filme! Recomendo a todos.', '2023-08-27 15:30:00', FALSE, 569094, 2),
    (2, 3, 'O filme teve alguns momentos interessantes, mas o final me deixou um pouco decepcionado.', '2023-08-27 16:45:00', FALSE, 667538, 2),
    (3, 5, 'Sem palavras, esse filme é simplesmente incrível e ele morre e é uma boneca!', '2023-08-27 18:20:00', TRUE, 346698, 3);

INSERT INTO lista (ID, NOME_DA_LISTA, USUARIO_ID)
VALUES
    (1, 'Favoritos', 1),
    (2, 'Assistir Mais Tarde', 1),
    (3, 'Comédias Favoritas', 3),
    (4, 'Ação e Aventura', 4),
    (5, 'Lista A', 2),
    (6, 'Lista B', 2),
    (7, 'Romances Queridos', 3),
    (8, 'Suspense e Mistério', 3);

INSERT INTO lista_tabela (TMDB_ID_FILME, LISTA_FILME_ID, USUARIO_ID)
VALUES
    (346698, 5, 2),
    (872585, 5, 2);

INSERT INTO votacao (ID, AVALIACAO, TMDB_ID_FILME, USUARIO_ID)
VALUES
    (1, 5, 346698, 2),
    (2, 4, 346698, 3);



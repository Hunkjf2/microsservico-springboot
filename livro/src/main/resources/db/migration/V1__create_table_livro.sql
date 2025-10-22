CREATE TABLE livro (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    isbn VARCHAR(13) UNIQUE NOT NULL,
    id_autor BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_livro_id_autor ON livro(id_autor);
CREATE INDEX idx_livro_titulo ON livro(titulo);
CREATE INDEX idx_livro_isbn ON livro(isbn);
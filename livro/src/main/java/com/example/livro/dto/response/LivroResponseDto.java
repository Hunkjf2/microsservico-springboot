package com.example.livro.dto.response;

import java.time.LocalDateTime;

public record LivroResponseDto(
        Long id,
        String titulo,
        String isbn,
        String descricao,
        Long idAutor,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){ }
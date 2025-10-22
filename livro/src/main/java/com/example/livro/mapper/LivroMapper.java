package com.example.livro.mapper;

import com.example.livro.dto.request.LivroRequestDto;
import com.example.livro.dto.response.LivroResponseDto;
import com.example.livro.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public Livro toEntity(LivroRequestDto request) {
        return Livro.builder()
                .titulo(request.titulo())
                .isbn(request.isbn())
                .descricao(request.descricao())
                .idAutor(request.idAutor())
                .build();
    }

    public LivroResponseDto toResponse(Livro livro) {
        return new LivroResponseDto(
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getDescricao(),
                livro.getIdAutor(),
                livro.getCreatedAt(),
                livro.getUpdatedAt()
        );
    }

    public Livro updateEntity(LivroRequestDto request, Livro livro) {
        livro.setTitulo(request.titulo());
        livro.setIsbn(request.isbn());
        livro.setDescricao(request.descricao());
        livro.setIdAutor(request.idAutor());
        return livro;
    }

}
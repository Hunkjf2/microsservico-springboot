package com.example.livro.controller;

import com.example.livro.dto.request.LivroRequestDto;
import com.example.livro.dto.response.LivroResponseDto;
import com.example.livro.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
@Tag(name = "Livro", description = "Operações relacionadas a livros")
public class LivroController {

    private final LivroService livroService;

    @GetMapping()
    @Operation(summary = "Listar todos os livros")
    public ResponseEntity<List<LivroResponseDto>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar livro por ID")
    public ResponseEntity<LivroResponseDto> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.consultar(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar livro")
    public ResponseEntity<LivroResponseDto> cadastrar(
            @RequestBody @Valid LivroRequestDto livroRequestDto) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                livroService.cadastrar(livroRequestDto)
            );
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar livro")
    public ResponseEntity<LivroResponseDto> editar(@PathVariable Long id,
                                                   @RequestBody @Valid LivroRequestDto livroRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                livroService.editar(id, livroRequestDto)
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar livro")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

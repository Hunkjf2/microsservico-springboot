package com.example.livro.dto.request;

import jakarta.validation.constraints.*;

public record LivroRequestDto(
        @NotBlank(message = "O título é obrigatório")
        @Size(max = 255, message = "O título não pode exceder 255 caracteres")
        String titulo,

        @NotBlank(message = "O ISBN é obrigatório")
        @Pattern(regexp = "^\\d{13}$", message = "O ISBN deve conter exatamente 13 dígitos")
        String isbn,

        @Size(max = 5000, message = "A descrição não pode exceder 5000 caracteres")
        String descricao,

        @NotNull(message = "O ID do autor é obrigatório")
        @Positive(message = "O ID do autor deve ser um número positivo")
        Long idAutor
) { }
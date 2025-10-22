package com.example.livro.service;

import com.example.livro.config.exception.LivroException;
import com.example.livro.dto.request.LivroRequestDto;
import com.example.livro.dto.response.LivroResponseDto;
import com.example.livro.mapper.LivroMapper;
import com.example.livro.model.Livro;
import com.example.livro.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static com.example.livro.constants.MensagemSistema.*;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    @Transactional(readOnly = true)
    public List<LivroResponseDto> listarTodos() {
        return livroRepository.findAll().stream()
                .map(livroMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public LivroResponseDto consultar(Long id) {
        return livroMapper.toResponse(getLivro(id));
    }

    private Livro getLivro(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new LivroException(REGISTRO_NAO_ENCONTRADO));
    }

    @Transactional
    public LivroResponseDto cadastrar(LivroRequestDto livroRequestDto) {
        Livro livro = livroMapper.toEntity(livroRequestDto);
        return livroMapper.toResponse(salvar(livro));
    }

    private Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    @Transactional
    public LivroResponseDto editar(Long id, LivroRequestDto livroRequestDto) {
        Livro livro = livroMapper.updateEntity(livroRequestDto, getLivro(id));
        return livroMapper.toResponse(this.salvar(livro));
    }

    @Transactional
    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }

}
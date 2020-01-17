package br.org.restapi.service;

import br.org.restapi.domains.Livro;
import br.org.restapi.repository.LivrosRepository;
import br.org.restapi.service.exception.LivroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    public List<Livro> listar() {
        return livrosRepository.findAll();
    }

    public Optional<Livro> buscar(Long id) {
        Optional<Livro> livro = livrosRepository.findById(id);

        if(livro == null) {
            throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
        }

        return livro;
    }

    public Livro salvar(Livro livro) {
        livro.setId(null);
        return livrosRepository.save(livro);
    }

    public void deletar(Long id) {
        try {
            livrosRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
        }
    }

    public void atualizar(Livro livro) {
        verificarExistencia(livro);
        livrosRepository.save(livro);
    }

    private void verificarExistencia(Livro livro) {
        buscar(livro.getId());
    }

}


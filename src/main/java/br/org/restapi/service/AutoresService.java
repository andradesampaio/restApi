package br.org.restapi.service;

import br.org.restapi.domains.Autor;
import br.org.restapi.repository.AutoresRepository;
import br.org.restapi.service.exception.AutorExistenteException;
import br.org.restapi.service.exception.AutorNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autor> listar() {
        return autoresRepository.findAll();
    }

    public Autor salvar(Autor autor) {

        if (autor.getId() != null) {
            Optional<Autor> byAutor = autoresRepository.findById(autor.getId());
            if (autor != null) {
                throw new AutorExistenteException("O autor já existe.");
            }
        }
        return autoresRepository.save(autor);
    }

    public Autor buscar(Long id) {
        return autoresRepository.findById(id).orElseThrow(() -> new AutorNaoEncontradoException("O autor não pôde ser encontrado."));
    }
}

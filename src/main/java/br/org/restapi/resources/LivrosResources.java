package br.org.restapi.resources;

import br.org.restapi.domains.Livro;
import br.org.restapi.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livros")
public class LivrosResources {

    @Autowired
    private LivrosRepository livrosRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Livro> listar() {
        return livrosRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void salvar(@RequestBody Livro livro) {
        livrosRepository.save(livro);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Livro> buscar(@PathVariable("id") Long id) {
        return livrosRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id) {
        livrosRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@RequestBody Livro livro, @PathVariable("id") Long id) {
        livro.setId(id);
        livrosRepository.save(livro);
    }
}

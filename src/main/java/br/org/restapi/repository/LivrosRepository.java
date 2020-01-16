package br.org.restapi.repository;

import br.org.restapi.domains.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
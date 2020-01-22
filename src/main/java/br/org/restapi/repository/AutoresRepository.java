package br.org.restapi.repository;

import br.org.restapi.domains.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
package br.org.restapi.repository;

import br.org.restapi.domains.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
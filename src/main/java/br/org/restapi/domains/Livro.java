package br.org.restapi.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String editora;
    private String resumo;
    @OneToMany(mappedBy = "livro")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Comentario> comentarios;
    @ManyToOne
    @JoinColumn(name = "AUTOR_ID")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Autor autor;
}
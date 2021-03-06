package br.org.restapi.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("name")
    private String nome;
    private String editora;
    //@NotEmpty(message = "O resumo de ver preenchido.")
    //@Size(max = 1500, message = "O resumo não pode conter mais de 1500 caracteres.")
    private String resumo;
    @OneToMany(mappedBy = "livro")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Comentario> comentarios;
    @ManyToOne
    @JoinColumn(name = "AUTOR_ID")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Autor autor;
}
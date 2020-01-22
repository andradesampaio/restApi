package br.org.restapi.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private String usuario;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LIVRO_ID")
    @JsonIgnore
    private Livro livro;
}

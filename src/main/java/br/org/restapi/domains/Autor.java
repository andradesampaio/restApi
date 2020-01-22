package br.org.restapi.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;
    private String nacionalidade;
    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private List<Livro> livros;



}

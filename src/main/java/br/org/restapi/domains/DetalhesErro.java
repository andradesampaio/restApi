package br.org.restapi.domains;

import lombok.Data;

@Data
public class DetalhesErro {
    private String titulo;

    private Long status;

    private Long timestamp;

    private String mensagemDesenvolvedor;

    public String getTitulo() {
        return titulo;
    }
}

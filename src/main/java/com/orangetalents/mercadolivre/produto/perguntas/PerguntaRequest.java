package com.orangetalents.mercadolivre.produto.perguntas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.usuario.Usuario;

import javax.validation.constraints.NotBlank;

public class PerguntaRequest {

    @NotBlank
    private String titulo;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PerguntaRequest(String titulo) {
        this.titulo = titulo;
    }

    public Pergunta toModel(Usuario usuarioLogado, Produto produto) {
        return new Pergunta(titulo, produto, usuarioLogado);
    }

}

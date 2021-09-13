package com.orangetalents.mercadolivre.produto.perguntas;

import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.usuario.Usuario;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PerguntaResponse {

    private Long id;
    private String titulo;
    private LocalDateTime instanteCriacao;
    private Usuario usuario;

    public PerguntaResponse(Pergunta pergunta) {
        this.id = pergunta.getId();
        this.titulo = pergunta.getTitulo();
        this.instanteCriacao = pergunta.getInstanteCriacao();
        this.usuario = pergunta.getUsuario();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

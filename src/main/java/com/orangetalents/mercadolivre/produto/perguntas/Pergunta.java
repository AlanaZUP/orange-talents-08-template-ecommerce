package com.orangetalents.mercadolivre.produto.perguntas;

import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Pergunta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotNull
    private LocalDateTime instanteCriacao;

    @NotNull @ManyToOne
    private Produto produto;

    @NotNull @ManyToOne
    private Usuario usuario;

    @Deprecated
    public Pergunta() {
    }

    public Pergunta(String titulo, Produto produto, Usuario usuario) {
        this.titulo = titulo;
        this.produto = produto;
        this.usuario = usuario;
        this.instanteCriacao = LocalDateTime.now();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

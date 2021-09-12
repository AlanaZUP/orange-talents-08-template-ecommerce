package com.orangetalents.mercadolivre.produto.opnioes;

import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.hibernate.validator.constraints.Range;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OpiniaoDto {

    private Long id;
    private int nota;
    private String titulo;
    private String descricao;
    private Usuario usuario;

    public OpiniaoDto(Opiniao opiniao) {
        id = opiniao.getId();
        nota = opiniao.getNota();
        titulo = opiniao.getTitulo();
        descricao = opiniao.getDescricao();
        usuario = opiniao.getUsuario();
    }

    public Long getId() {
        return id;
    }

    public int getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

package com.orangetalents.mercadolivre.produto.opnioes;

import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OpiniaoRequest {

    @NotNull @Range(min = 1, max = 5, message = "A nota deve ser entre 1 e 5")
    private int nota;

    @NotBlank
    private String titulo;

    @NotBlank @Size(max = 500)
    private String descricao;

    public OpiniaoRequest(int nota, String titulo, String descricao) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Opiniao toModel(Usuario usuarioLogado, Produto produto) {
        return new Opiniao(nota, titulo, descricao, usuarioLogado, produto);
    }
}

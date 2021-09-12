package com.orangetalents.mercadolivre.produto.imagens;

import com.orangetalents.mercadolivre.produto.Produto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ImagemProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String imagem;

    @NotNull
    @ManyToOne
    private Produto produto;

    public ImagemProduto(String imagem, Produto produto) {
        this.imagem = imagem;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public String getImagem() {
        return imagem;
    }

}

package com.orangetalents.mercadolivre.produto.detalhes;

import com.orangetalents.mercadolivre.produto.caracteristica.Caracteristica;

public class DetalhaProdutoCaracteristicas {
    private String nome;
    private String descricao;

    public DetalhaProdutoCaracteristicas(Caracteristica caracteristica) {
        this.nome = caracteristica.getNome();
        this.descricao = caracteristica.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}

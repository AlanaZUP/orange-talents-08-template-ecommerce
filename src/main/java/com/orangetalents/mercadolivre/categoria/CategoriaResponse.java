package com.orangetalents.mercadolivre.categoria;



import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

public class CategoriaResponse {

    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;
    @ManyToOne
    private Categoria categoriaMae;

    public CategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.categoriaMae = categoria.getCategoriaMae();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoriaMae() {
        return categoriaMae;
    }
}


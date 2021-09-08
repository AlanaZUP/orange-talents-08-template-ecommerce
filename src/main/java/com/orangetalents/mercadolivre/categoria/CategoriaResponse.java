package com.orangetalents.mercadolivre.teste;



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
}


package com.orangetalents.mercadolivre.categoria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.orangetalents.mercadolivre.comms.anotations.CampoUnico;
import com.orangetalents.mercadolivre.comms.anotations.ExistisId;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @CampoUnico(nomeCampo = "nome", classe = Categoria.class)
    private String nome;

    @ExistisId(classe = Categoria.class, acceptedNull = true)
    private Long idCategoriaMae;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoriaRequest(String nome, Long idCategoriaMae) {
        this.nome = nome;
        this.idCategoriaMae = idCategoriaMae;
    }

    public Categoria toModel(CategoriaRepository categoriaRepository){
        Categoria categoria = new Categoria(nome);
        if(idCategoriaMae != null) {
            Categoria categoriaMae = categoriaRepository.findById(idCategoriaMae).get();
            categoria.setCategoriaMae(categoriaMae);
        }
        return categoria;
    }
}

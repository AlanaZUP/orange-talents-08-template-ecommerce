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
        if(idCategoriaMae != null) {
            Categoria categoriaMae = categoriaRepository.findById(idCategoriaMae).get();
            return new Categoria(nome, categoriaMae);
        }
        return new Categoria(nome);
    }
}

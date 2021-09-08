package com.orangetalents.mercadolivre.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CadastraCategorias {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CategoriaResponse cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRequest.toModel(categoriaRepository);
        categoria = categoriaRepository.save(categoria);
        return new CategoriaResponse(categoria);
    }
}

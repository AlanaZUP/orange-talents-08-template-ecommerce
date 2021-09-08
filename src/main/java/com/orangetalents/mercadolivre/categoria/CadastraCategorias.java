package com.orangetalents.mercadolivre.teste;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/teste")
public class CadastraCategorias {

    @PostMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void teste(@RequestBody @Valid CategoriaRequest teste){

    }
}

package com.orangetalents.mercadolivre.notaFiscal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/notasfiscais")
public class NotaFiscalController {

    @PostMapping
    public void criaNotaFiscal(@Valid @RequestBody NotaFiscalRequest notaFiscalRequest){
        System.out.println("\n\nNota Fiscal:");
        System.out.println(notaFiscalRequest.toString());
        System.out.println("\n\n");
    }
}

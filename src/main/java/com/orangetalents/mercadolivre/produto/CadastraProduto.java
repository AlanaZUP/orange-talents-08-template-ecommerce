package com.orangetalents.mercadolivre.produto;

import com.orangetalents.mercadolivre.categoria.CategoriaRepository;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class CadastraProduto {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse cadastraProduto(@RequestBody @Valid ProdutoRequest produtoRequest, @AuthenticationPrincipal Usuario usuario){

        Produto produto = produtoRequest.toModel(categoriaRepository, usuario);
        produtoRepository.save(produto);

        return new ProdutoResponse(produto);
    }
}

package com.orangetalents.mercadolivre.produto.detalhes;

import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/produtos")
public class DetalheController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/{id}")
    public ProdutoDetalhar detalhaProduto(@PathVariable("id") Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe produto com o id recebido"));
        return new ProdutoDetalhar(produto);
    }
}

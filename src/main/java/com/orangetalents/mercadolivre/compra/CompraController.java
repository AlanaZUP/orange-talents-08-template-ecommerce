package com.orangetalents.mercadolivre.compra;

import com.orangetalents.mercadolivre.comms.utils.EnviaEmals;
import com.orangetalents.mercadolivre.produto.ProdutoRepository;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EnviaEmals enviaEmals;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.FOUND)
    public String realizaCompra(@AuthenticationPrincipal Usuario usuarioLogado, @Valid @RequestBody CompraRequest compraRequest){
        Compra compra = compraRequest.toModel(usuarioLogado, produtoRepository);
        compraRepository.save(compra);
        enviaEmals.envia("mercadolivre@gmail.com", compra.getProduto().getUsuario().getLogin(), "Nova Compra", "Uma nova compra para o produto"+compra.getProduto().getNome());
        return compra.getGatewayPagamento().url(compra.getId());
    }
}

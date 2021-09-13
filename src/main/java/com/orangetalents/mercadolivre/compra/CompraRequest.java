package com.orangetalents.mercadolivre.compra;

import com.orangetalents.mercadolivre.comms.anotations.ExistisId;
import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.produto.ProdutoRepository;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CompraRequest {

    @NotNull @Positive
    private Integer quantidade;
    @NotNull @ExistisId(classe = Produto.class, acceptedNull = false)
    private Long idProduto;
    @NotNull
    private GatewayPagamento gatewayPagamento;

    public CompraRequest(Integer quantidade, Long idProduto, GatewayPagamento gatewayPagamento) {
        this.quantidade = quantidade;
        this.idProduto = idProduto;
        this.gatewayPagamento = gatewayPagamento;
    }

    public Compra toModel(Usuario usuarioLogado, ProdutoRepository produtoRepository){
        Produto produto = produtoRepository.findById(idProduto).get();
        if(produto.abateEstoque(quantidade)){
            return new Compra(usuarioLogado, produto, quantidade, gatewayPagamento);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O estoque não possui quantidade suficiente");
    }
}

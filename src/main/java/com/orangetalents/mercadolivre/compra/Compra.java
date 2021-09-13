package com.orangetalents.mercadolivre.compra;

import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Compra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @NotNull
    private Usuario comprador;
    @ManyToOne @NotNull
    private Produto produto;
    @Positive @NotNull
    private Integer quantidade;
    @NotNull
    private GatewayPagamento gatewayPagamento;
    @NotNull
    private StatusCompra status;

    public Compra(Usuario usuarioLogado, Produto produto, @NotNull @Positive Integer quantidade, @NotNull GatewayPagamento gatewayPagamento) {
        this.comprador = usuarioLogado;
        this.produto = produto;
        this.quantidade = quantidade;
        this.gatewayPagamento = gatewayPagamento;
        this.status = StatusCompra.INICIADO;
    }

    public Long getId() {
        return id;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public GatewayPagamento getGatewayPagamento() {
        return gatewayPagamento;
    }

    public StatusCompra getStatus() {
        return status;
    }
}

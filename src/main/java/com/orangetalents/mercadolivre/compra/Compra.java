package com.orangetalents.mercadolivre.compra;

import com.orangetalents.mercadolivre.compra.transacao.StatusTransacao;
import com.orangetalents.mercadolivre.compra.transacao.Transacao;
import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;
import java.util.stream.Collectors;

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

    @OneToMany(mappedBy = "compra", cascade = CascadeType.MERGE)
    private Set<Transacao> transacaos;

    @Deprecated
    public Compra() {
    }

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

    public void adicionaTransacao(Transacao transacao){
        if(status.equals(StatusCompra.FINALIZADO)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Compra finalizada");
        }
//        if(possuiTransacaoAprovada()){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Uma compra não pode possuir mais de uma transação aprovada");
//        }

        this.transacaos.add(transacao);

        if(transacao.getStatusTransacao().equals(StatusTransacao.SUCESSO)){
            this.status = StatusCompra.FINALIZADO;
        }
    }

    private boolean possuiTransacaoAprovada() {
        return !transacaos.stream()
                .filter(Transacao::aprovada)
                .collect(Collectors.toSet()).isEmpty();
    }

}

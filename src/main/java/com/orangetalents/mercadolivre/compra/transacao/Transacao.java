package com.orangetalents.mercadolivre.compra.transacao;

import com.orangetalents.mercadolivre.compra.Compra;
import com.orangetalents.mercadolivre.compra.transacao.processos.Processo;
import com.orangetalents.mercadolivre.compra.transacao.processos.processaEmails.EnviaEmailFalha;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Compra compra;
    @NotBlank
    private String idPagamento;
    @NotNull
    private LocalDateTime instanteTransacao;
    @NotNull
    private StatusTransacao statusTransacao;

    @Deprecated
    public Transacao() {
    }

    public Transacao(Compra compra, String idPagamento, StatusTransacao statusTransacao) {
        this.compra = compra;
        this.idPagamento = idPagamento;
        this.statusTransacao = statusTransacao;
        this.instanteTransacao = LocalDateTime.now();
    }

    public boolean aprovada() {
        return this.statusTransacao.equals(StatusTransacao.SUCESSO);
    }

    public StatusTransacao getStatusTransacao() {
        return statusTransacao;
    }

    public void processa(Processo processo) {
        processo.processa(this.compra);
    }
}

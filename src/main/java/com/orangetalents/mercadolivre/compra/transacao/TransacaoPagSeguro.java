package com.orangetalents.mercadolivre.compra.transacao;

import com.orangetalents.mercadolivre.comms.anotations.ExistisId;
import com.orangetalents.mercadolivre.compra.Compra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TransacaoPagSeguro implements TransacaoRequest{

    @NotNull @ExistisId(classe = Compra.class, acceptedNull = false)
    private Long idCompra;
    @NotBlank
    private String idPagamento;
    @NotNull
    private StatusPagSeguro status;

    public TransacaoPagSeguro(Long idCompra, String idPagamento, StatusPagSeguro status) {
        this.idCompra = idCompra;
        this.idPagamento = idPagamento;
        this.status = status;
    }

    @Override
    public Transacao toModel(Compra compra) {
        if(status.equals(StatusPagSeguro.SUCESSO)){
            return new Transacao(compra, idPagamento, StatusTransacao.SUCESSO);
        }
        return new Transacao(compra, idPagamento, StatusTransacao.FALHA);
    }

    @Override
    public Long getIdCompra() {
        return idCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoPagSeguro that = (TransacaoPagSeguro) o;
        return Objects.equals(idCompra, that.idCompra) && Objects.equals(idPagamento, that.idPagamento) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompra, idPagamento, status);
    }
}

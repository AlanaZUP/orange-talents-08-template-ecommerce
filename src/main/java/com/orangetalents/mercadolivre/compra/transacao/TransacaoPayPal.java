package com.orangetalents.mercadolivre.compra.transacao;

import com.orangetalents.mercadolivre.comms.anotations.ExistisId;
import com.orangetalents.mercadolivre.compra.Compra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransacaoPayPal implements TransacaoRequest{
    @NotNull
    @ExistisId(classe = Compra.class, acceptedNull = false)
    private Long idCompra;
    @NotBlank
    private String idPagamento;
    @NotNull
    private Byte status;

    public TransacaoPayPal(Long idCompra, String idPagamento, Byte status) {
        this.idCompra = idCompra;
        this.idPagamento = idPagamento;
        this.status = status;
    }

    @Override
    public Transacao toModel(Compra compra) {
        if(status == 1){
            return new Transacao(compra, idPagamento, StatusTransacao.SUCESSO);
        }
        return new Transacao(compra, idPagamento, StatusTransacao.FALHA);
    }

    @Override
    public Long getIdCompra() {
        return idCompra;
    }
}

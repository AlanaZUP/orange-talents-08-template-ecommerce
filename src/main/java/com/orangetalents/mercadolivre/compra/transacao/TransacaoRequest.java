package com.orangetalents.mercadolivre.compra.transacao;

import com.orangetalents.mercadolivre.compra.Compra;

public interface TransacaoRequest {
    Transacao toModel(Compra compra);

    public Long getIdCompra();
}

package com.orangetalents.mercadolivre.compra.transacao.processos;

import com.orangetalents.mercadolivre.compra.Compra;

public interface Processo {

    void processa(Compra compra);
}

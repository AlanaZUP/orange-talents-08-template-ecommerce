package com.orangetalents.mercadolivre.compra.transacao.processos.processaNotaFiscal;

import com.orangetalents.mercadolivre.compra.Compra;
import com.orangetalents.mercadolivre.compra.transacao.processos.Processo;
import com.orangetalents.mercadolivre.notaFiscal.NotaFiscalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeraNotaFiscal implements Processo {

    @Autowired
    private NotaFiscal notaFiscal;

    @Override
    public void processa(Compra compra) {
        Long idUsuario = compra.getComprador().getId();
        Long idCompra = compra.getId();
        NotaFiscalRequest notaFiscalRequest = new NotaFiscalRequest(idCompra, idUsuario);
        notaFiscal.save(notaFiscalRequest);
    }
}

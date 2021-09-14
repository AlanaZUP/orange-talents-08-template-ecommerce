package com.orangetalents.mercadolivre.compra.transacao.processos;

import com.orangetalents.mercadolivre.compra.transacao.Transacao;
import com.orangetalents.mercadolivre.compra.transacao.processos.processaEmails.EnviaEmailFalha;
import com.orangetalents.mercadolivre.compra.transacao.processos.processaEmails.EnviaEmailSucesso;
import com.orangetalents.mercadolivre.compra.transacao.processos.processaNotaFiscal.GeraNotaFiscal;
import com.orangetalents.mercadolivre.compra.transacao.processos.processaRanking.AtualizaRankingVendedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RealizaProcessos {

    @Autowired
    private EnviaEmailSucesso enviaEmailSucesso;

    @Autowired
    private EnviaEmailFalha enviaEmailFalha;

    @Autowired
    private GeraNotaFiscal notaFiscal;

    @Autowired
    private AtualizaRankingVendedores atualizaRankingVendedores;

    public void processa(Transacao transacao){
        if(transacao.aprovada()){
            transacao.processa(notaFiscal);
            transacao.processa(atualizaRankingVendedores);
            transacao.processa(enviaEmailSucesso);
            return;
        }
        transacao.processa(enviaEmailFalha);
    }

}

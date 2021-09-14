package com.orangetalents.mercadolivre.compra.transacao.processos.processaEmails;

import com.orangetalents.mercadolivre.comms.utils.EnviaEmals;
import com.orangetalents.mercadolivre.compra.Compra;
import com.orangetalents.mercadolivre.compra.transacao.processos.Processo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnviaEmailSucesso implements Processo {

    @Autowired
    private EnviaEmals enviaEmals;

    @Override
    public void processa(Compra compra) {
        String destinatario = "mercadolivrefake@gmail.com";
        String remetente = compra.getComprador().getLogin();
        String titulo = "Compra realizada";
        String mensagem = "Compra do produto "+ compra.getProduto().getNome() + " realizada com sucesso!";
        enviaEmals.envia(destinatario, remetente, titulo, mensagem);
    }
}

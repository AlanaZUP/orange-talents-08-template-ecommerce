package com.orangetalents.mercadolivre.compra.transacao.processos.processaEmails;

import com.orangetalents.mercadolivre.comms.utils.EnviaEmals;
import com.orangetalents.mercadolivre.compra.Compra;
import com.orangetalents.mercadolivre.compra.transacao.processos.Processo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnviaEmailFalha implements Processo {

    @Autowired
    private EnviaEmals enviaEmals;

    @Override
    public void processa(Compra compra) {
        String destinatario = "mercadolivrefake@gmail.com";
        String remetente = compra.getComprador().getLogin();
        String titulo = "Falha ao realizar compra";
        String url = "http://localhost:8080/compra";
        String mensagem = "Não foi possível realizar a compra do produto "+ compra.getProduto().getNome() + "\nTente novamente acessando o link "+ url;
        enviaEmals.envia(destinatario, remetente, titulo, mensagem);
    }
}

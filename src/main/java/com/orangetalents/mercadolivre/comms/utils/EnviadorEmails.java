package com.orangetalents.mercadolivre.comms.utils;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EnviadorEmails implements EnviaEmals{
    @Override
    public void envia(String remetente, String destinatário, String titulo, String mensagem) {
        System.out.println(remetente);
        System.out.println(destinatário);
        System.out.println(titulo);
        System.out.println(mensagem);
    }
}

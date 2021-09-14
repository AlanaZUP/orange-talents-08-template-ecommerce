package com.orangetalents.mercadolivre.compra.transacao.processos.processaNotaFiscal;

import com.orangetalents.mercadolivre.comms.feign.FeignConfiguration;
import com.orangetalents.mercadolivre.notaFiscal.NotaFiscalRequest;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;

@FeignClient(name = "nf", configuration = FeignConfiguration.class, url = "http://localhost:8080/")
public interface NotaFiscal {

    @PostMapping("/notasfiscais")
    void save (NotaFiscalRequest notaFiscalRequest);
}

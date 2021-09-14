package com.orangetalents.mercadolivre.compra.transacao;

import com.orangetalents.mercadolivre.compra.Compra;
import com.orangetalents.mercadolivre.compra.CompraRepository;
import com.orangetalents.mercadolivre.compra.transacao.processos.RealizaProcessos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class TransacaoController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private RealizaProcessos realizaProcessos;


    @PostMapping("/pagseguro")
    @Transactional
    public void transacaoPagseguro(@Valid @RequestBody TransacaoPagSeguro transacaoPagSeguro){
        cadastraTransacao(transacaoPagSeguro);
    }

    @PostMapping("/paypal")
    @Transactional
    public void transacaoPaypal(@Valid @RequestBody TransacaoPayPal transacaoPayPal){
        cadastraTransacao(transacaoPayPal);
    }


    private void cadastraTransacao(TransacaoRequest transacaoRequest){
        Compra compra = compraRepository.findById(transacaoRequest.getIdCompra()).get();
        Transacao transacao = transacaoRequest.toModel(compra);
        compra.adicionaTransacao(transacao);
        compraRepository.save(compra);
        realizaProcessos.processa(transacao);
    }
}

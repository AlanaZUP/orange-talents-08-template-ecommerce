package com.orangetalents.mercadolivre.compra.transacao.processos.processaRanking;

import com.orangetalents.mercadolivre.compra.Compra;
import com.orangetalents.mercadolivre.compra.transacao.processos.Processo;
import com.orangetalents.mercadolivre.ranking.RankingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizaRankingVendedores implements Processo {

    @Autowired
    private RankingClient rankingClient;

    @Override
    public void processa(Compra compra) {
        Long idVendedor = compra.getProduto().getUsuario().getId();
        Long idCompra = compra.getId();
        RankingRequest rankingRequest = new RankingRequest(idCompra, idVendedor);
        rankingClient.save(rankingRequest);
    }
}

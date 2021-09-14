package com.orangetalents.mercadolivre.compra.transacao.processos.processaRanking;

import com.orangetalents.mercadolivre.comms.feign.FeignConfiguration;
import com.orangetalents.mercadolivre.ranking.RankingRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ranking", configuration = FeignConfiguration.class, url = "http://localhost:8080/")
public interface RankingClient {

    @PostMapping("/ranking")
    void save (RankingRequest rankingRequest);
}

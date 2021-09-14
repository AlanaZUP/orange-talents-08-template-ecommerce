package com.orangetalents.mercadolivre.ranking;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @PostMapping
    public void atualizaRanking(@Valid @RequestBody RankingRequest rankingRequest){
        System.out.println("\n\nRanking");
        System.out.println(rankingRequest.toString());
        System.out.println("\n\n");
    }
}

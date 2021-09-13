package com.orangetalents.mercadolivre.produto.perguntas;

import com.orangetalents.mercadolivre.comms.utils.EnviaEmals;
import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.produto.ProdutoRepository;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class PerguntaController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EnviaEmals enviaEmals;

    @PostMapping("/{id}/perguntas")
    public PerguntaResponse adicionaPergunta(@PathVariable("id") Long id, @Valid @RequestBody PerguntaRequest perguntaRequest, @AuthenticationPrincipal Usuario usuarioLogado){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe produto com o id recebido"));
        Pergunta pergunta = perguntaRequest.toModel(usuarioLogado, produto);
        produto.adicionaPergunta(pergunta);

        produtoRepository.save(produto);
        enviaEmals.envia("mercadolivrefake@gmail.com", produto.getUsuario().getLogin(), "Nova Pergunta para o Produto: " + produto.getNome(), pergunta.getTitulo());

        return new PerguntaResponse(pergunta);
    }
}

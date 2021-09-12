package com.orangetalents.mercadolivre.produto;

import com.orangetalents.mercadolivre.categoria.CategoriaRepository;
import com.orangetalents.mercadolivre.comms.anotations.ExistisId;
import com.orangetalents.mercadolivre.produto.imagens.ImagensRequest;
import com.orangetalents.mercadolivre.produto.imagens.UploadFake;
import com.orangetalents.mercadolivre.produto.imagens.Uploader;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class CadastraProduto {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private Uploader uploadFake;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse cadastraProduto(@RequestBody @Valid ProdutoRequest produtoRequest, @AuthenticationPrincipal Usuario usuario){

        Produto produto = produtoRequest.toModel(categoriaRepository, usuario);
        produtoRepository.save(produto);

        return new ProdutoResponse(produto);
    }

    @PostMapping("/{id}/imagens")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionaImagens(@PathVariable Long id, @Valid ImagensRequest imagensRequest, @AuthenticationPrincipal Usuario usuarioLogado){
        Produto produto = produtoRepository.findById(id).orElseThrow(() ->   new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe produto com o id informado"));
        if(!produto.belongsToUsuario(usuarioLogado)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuário não tem permição para inserir imagens no produto");
        }

        List<String> imagensUrls = uploadFake.enviaImagensParaServidorFake(imagensRequest.getImagens());
        produto.adicionaImagens(imagensUrls);

        return produto;
    }
}

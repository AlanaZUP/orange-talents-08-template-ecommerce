package com.orangetalents.mercadolivre.produto.detalhes;

import com.orangetalents.mercadolivre.categoria.Categoria;
import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.produto.imagens.ImagemProduto;
import com.orangetalents.mercadolivre.produto.opnioes.Opiniao;
import com.orangetalents.mercadolivre.produto.perguntas.Pergunta;
import com.orangetalents.mercadolivre.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProdutoDetalhar {

    private Long id;
    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    private String descricao;
    private LocalDateTime instanteCadastro;
    private Usuario usuario;
    private Categoria categoria;
    private double mediaNotas;
    private Set<DetalhaProdutoCaracteristicas> caracteristicas;
    private Set<String> imagens;
    private Set<Map<String, String>> opinioes;
    private Set<String> perguntas;

    public ProdutoDetalhar(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.quantidade = produto.getQuantidade();
        this.descricao = produto.getDescricao();
        this.instanteCadastro = produto.getInstanteCadastro();
        this.usuario = produto.getUsuario();
        this.categoria = produto.getCategoria();
        this.caracteristicas = produto.mapCaracteristicas(DetalhaProdutoCaracteristicas::new);
        this.imagens = produto.mapImagens(ImagemProduto::getImagem);
        this.opinioes = produto.mapOpinioes(opiniao -> Map.of("titulo", opiniao.getTitulo(), "descricao", opiniao.getDescricao()));
        this.perguntas = produto.mapPerguntas(Pergunta::getTitulo);

        Set<Integer> notas = produto.mapOpinioes(Opiniao::getNota);
        IntStream intStream = notas.stream().mapToInt(nota -> nota);
        OptionalDouble average = intStream.average();
        mediaNotas = average.orElseGet(() -> 0.0);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Set<DetalhaProdutoCaracteristicas> getCaracteristicas() {
        return caracteristicas;
    }

    public Set<String> getImagens() {
        return imagens;
    }

    public Set<Map<String, String>> getOpinioes() {
        return opinioes;
    }

    public Set<String> getPerguntas() {
        return perguntas;
    }
}

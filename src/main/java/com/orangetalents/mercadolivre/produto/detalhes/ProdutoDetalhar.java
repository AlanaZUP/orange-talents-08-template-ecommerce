package com.orangetalents.mercadolivre.produto.detalhes;

import com.orangetalents.mercadolivre.categoria.Categoria;
import com.orangetalents.mercadolivre.produto.Produto;
import com.orangetalents.mercadolivre.produto.caracteristica.Caracteristica;
import com.orangetalents.mercadolivre.produto.imagens.ImagemProduto;
import com.orangetalents.mercadolivre.produto.opnioes.Opiniao;
import com.orangetalents.mercadolivre.produto.perguntas.Pergunta;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDetalhar {

    private Long id;
    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    private String descricao;
    private LocalDateTime instanteCadastro;
    private Usuario usuario;
    private Categoria categoria;
    private List<Caracteristica> caracteristicas = new ArrayList<>();
    private List<ImagemProduto> imagens = new ArrayList<>();
    private List<Opiniao> opinioes = new ArrayList<>();
    private List<Pergunta> perguntas = new ArrayList<>();

    public ProdutoDetalhar(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.quantidade = produto.getQuantidade();
        this.descricao = produto.getDescricao();
        this.instanteCadastro = produto.getInstanteCadastro();
        this.usuario = produto.getUsuario();
        this.categoria = produto.getCategoria();
        this.caracteristicas = produto.getCaracteristicas();
        this.imagens = produto.getImagens();
        this.opinioes = produto.getOpinioes();
        this.perguntas = produto.getPerguntas();
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

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public List<ImagemProduto> getImagens() {
        return imagens;
    }

    public List<Opiniao> getOpinioes() {
        return opinioes;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }
}

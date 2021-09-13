package com.orangetalents.mercadolivre.produto;

import com.orangetalents.mercadolivre.categoria.Categoria;
import com.orangetalents.mercadolivre.produto.caracteristica.Caracteristica;
import com.orangetalents.mercadolivre.produto.detalhes.DetalhaProdutoCaracteristicas;
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
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull @Positive
    private BigDecimal valor;

    @NotNull @PositiveOrZero
    private Integer quantidade;

    @NotBlank @Length(max = 1000)
    private String descricao;

    private LocalDateTime instanteCadastro;

    @ManyToOne @NotNull
    private Usuario usuario;

    @ManyToOne @NotNull
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Caracteristica> caracteristicas = new ArrayList<>();

    @OneToMany(mappedBy = "produto", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<ImagemProduto> imagens = new ArrayList<>();

    @OneToMany(mappedBy = "produto", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Opiniao> opinioes = new ArrayList<>();

    @OneToMany(mappedBy = "produto", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Pergunta> perguntas = new ArrayList<>();

    @Deprecated
    public Produto() {
    }

    public Produto(String nome, BigDecimal valor, Integer quantidade, String descricao, Usuario usuario, Categoria categoria) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.instanteCadastro = LocalDateTime.now();
        this.usuario = usuario;
        this.categoria = categoria;
    }

    public void addCaracteristicas(Caracteristica caracteristica){
        caracteristicas.add(caracteristica);
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

    public boolean belongsToUsuario(Usuario usuarioLogado) {
        return usuario.getId() == usuarioLogado.getId();
    }

    public void adicionaImagens(List<String> imagens){
        List<ImagemProduto> imagemProdutos = imagens.stream()
                .map(imagem -> new ImagemProduto(imagem, this))
                .collect(Collectors.toList());
        this.imagens.addAll(imagemProdutos);
    }

    public void adicionaOpniao(Opiniao opiniao) {
        opinioes.add(opiniao);
    }

    public void adicionaPergunta(Pergunta pergunta) {
        perguntas.add(pergunta);
    }

    public List<Opiniao> getOpinioes() {
        return opinioes;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public <T> Set<T> mapCaracteristicas(Function<Caracteristica, T> funcaoMap){
        return this.caracteristicas.stream().map(funcaoMap).collect(Collectors.toSet());
    }

    public <T> Set<T> mapImagens(Function<ImagemProduto, T> funcaoMap) {
        return imagens.stream().map(funcaoMap).collect(Collectors.toSet());
    }

    public <T> Set<T> mapPerguntas(Function<Pergunta, T> funcaoMap) {
        return perguntas.stream().map(funcaoMap).collect(Collectors.toSet());
    }

    public <T> Set<T> mapOpinioes(Function<Opiniao, T> funcaoMap) {
        return this.opinioes.stream().map(funcaoMap).collect(Collectors.toSet());
    }
}

package com.orangetalents.mercadolivre.produto;

import com.orangetalents.mercadolivre.categoria.Categoria;
import com.orangetalents.mercadolivre.categoria.CategoriaRepository;
import com.orangetalents.mercadolivre.comms.anotations.ExistisId;
import com.orangetalents.mercadolivre.produto.caracteristica.Caracteristica;
import com.orangetalents.mercadolivre.produto.caracteristica.CaracteristicaRequest;
import com.orangetalents.mercadolivre.usuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull @PositiveOrZero
    private Integer quantidade;

    @NotBlank @Length(max = 1000)
    private String descricao;

    @NotNull @ExistisId(acceptedNull = false, classe = Categoria.class)
    private Long idCategoria;

    @NotNull @Size(min = 3) @Valid
    private Set<CaracteristicaRequest> caracteristicas;

    public ProdutoRequest(String nome, BigDecimal valor, Integer quantidade, String descricao, Long idCategoria, Set<CaracteristicaRequest> caracteristicas) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.caracteristicas = caracteristicas;
    }

    public Produto toModel(CategoriaRepository categoriaRepository, Usuario usuarioLogado){
        Categoria categoria = categoriaRepository.findById(idCategoria).get();
        Produto produto = new Produto(nome, valor, quantidade, descricao, usuarioLogado, categoria);
        caracteristicas.forEach(caracteristica -> produto.addCaracteristicas(caracteristica.toModel()));
        return produto;
    }
}

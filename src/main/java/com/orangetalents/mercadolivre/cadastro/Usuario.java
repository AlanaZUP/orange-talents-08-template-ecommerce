package com.orangetalents.mercadolivre.cadastro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Email
    private String login;

    @NotBlank @Size(min = 6)
    private String senha;

    @PastOrPresent
    private LocalDateTime dataCadastro;

    public Usuario(String login, SenhaLimpa senha){
        this.login = login;
        this.senha = senha.toHash();
        this.dataCadastro = LocalDateTime.now();
    }
}

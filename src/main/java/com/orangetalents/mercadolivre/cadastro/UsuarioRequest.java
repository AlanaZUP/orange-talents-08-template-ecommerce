package com.orangetalents.mercadolivre.cadastro;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class UsuarioRequest {

    @NotBlank
    @Email
    private String login;

    @NotBlank @Size(min = 6)
    private String senha;

    @Deprecated
    public UsuarioRequest() {
    }

    public UsuarioRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario toModel(){
        SenhaLimpa senhaLimpa = new SenhaLimpa(senha);
        return new Usuario(login, senhaLimpa);
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}

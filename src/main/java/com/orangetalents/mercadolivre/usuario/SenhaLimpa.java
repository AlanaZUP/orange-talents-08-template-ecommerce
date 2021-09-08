package com.orangetalents.mercadolivre.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Size;

public class SenhaLimpa {
    private String senha;

    public SenhaLimpa(@Size(min = 6) String senha) {
        this.senha = senha;
    }

    public String toHash(){
        return new BCryptPasswordEncoder().encode(senha);
    }
}

package com.orangetalents.mercadolivre.cadastro;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

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

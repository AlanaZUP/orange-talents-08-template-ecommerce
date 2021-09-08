package com.orangetalents.mercadolivre.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class CadastrarUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRequest.toModel();
        usuarioRepository.save(usuario);
    }
}

package com.orangetalents.mercadolivre.cadastro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CadastrarUsuarioTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EntityManager manager;

    Gson gson = new Gson();

    @Test
    public void retornaBadRequestQuandoNaoRecebeNada() throws Exception {
        mockMvc.perform(post("/cadastro").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void retornaBadRequestQuandoRecebeEmailInvalido() throws Exception {
        UsuarioRequest usuarioRequest = new UsuarioRequest("loginErrado", "123456");
        mockMvc.perform(post("/cadastro")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(usuarioRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].campo").value("login"));
    }


    @Test
    public void retornaBadRequestQuandoRecebeSenhaMenorQue6() throws Exception {
        UsuarioRequest usuarioRequest = new UsuarioRequest("login@login.com", "12345");
        mockMvc.perform(post("/cadastro")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(usuarioRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].campo").value("senha"));
    }


    @Test
    public void retornaCreatedQuandoRecebeDadosCorretamente() throws Exception {
        UsuarioRequest usuarioRequest = new UsuarioRequest("login@teste.com", "123456");
        mockMvc.perform(post("/cadastro")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(usuarioRequest)))
                .andExpect(status().isCreated());
    }
    @Test
    public void retornaBadRequestQuandoRecebeLoginDuplicado() throws Exception {
        UsuarioRequest usuarioRequest = new UsuarioRequest("login@login.com", "123456");
        mockMvc.perform(post("/cadastro")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(usuarioRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].campo").value("login"));
    }

}

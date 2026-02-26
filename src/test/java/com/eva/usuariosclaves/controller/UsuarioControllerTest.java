package com.eva.usuariosclaves.controller;

import com.eva.usuariosclaves.dto.UsuarioDTO;
import com.eva.usuariosclaves.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
@WebMvcTest(UsuarioController.class)
@AutoConfigureMockMvc(addFilters = false)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void crearUsuario_deberiaRetornar201() throws Exception {

        UsuarioDTO dto = new UsuarioDTO(
                1L,
                "Juan",
                "juan@test.com",
                LocalDateTime.now(),
                "contraseña",      // ✔ password
                1L,                // ✔ proveedorId
                "Empresa Test"     // ✔ proveedorNombre
        );

        when(usuarioService.crearUsuario(org.mockito.ArgumentMatchers.any()))
                .thenReturn(dto);

        mockMvc.perform(post("/api/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())   // cambia a isCreated() si tu controller devuelve 201
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.proveedorNombre").value("Empresa Test"));
    }
    @Test
    void obtenerPorId_deberiaRetornarUsuario() throws Exception {

        UsuarioDTO dto = new UsuarioDTO(
                1L,
                "Ana",
                "ana@test.com",
                LocalDateTime.now(),
                "contraseña",   // ✔ password
                1L,             // ✔ proveedorId
                "Empresa"
        );

        when(usuarioService.obtenerPorId(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Ana"))
                .andExpect(jsonPath("$.proveedorNombre").value("Empresa"));
    }

    @Test
    void eliminarUsuario_deberiaRetornar200() throws Exception {

        mockMvc.perform(delete("/api/usuarios/1"))
                .andExpect(status().isOk());
    }
}
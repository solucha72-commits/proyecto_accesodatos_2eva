package com.eva.usuariosclaves.service;

import com.eva.usuariosclaves.dto.PerfilUsuarioDTO;
import com.eva.usuariosclaves.model.PerfilUsuario;
import com.eva.usuariosclaves.model.Usuario;
import com.eva.usuariosclaves.repository.PerfilUsuarioRepository;
import com.eva.usuariosclaves.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PerfilUsuarioServiceImplTest {

    @Mock
    private PerfilUsuarioRepository perfilRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private PerfilUsuarioServiceImpl perfilService;

    @Test
    void guardar_deberiaGuardarPerfil() {

        Usuario usuario = new Usuario();
        usuario.setNombre("Carlos");

        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setApodo("Carli");
        perfil.setUsuario(usuario);

        PerfilUsuarioDTO dto = new PerfilUsuarioDTO(null, "Carli", 1L);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(perfilRepository.save(any(PerfilUsuario.class))).thenReturn(perfil);

        PerfilUsuarioDTO resultado = perfilService.guardar(dto);

        assertEquals("Carli", resultado.getApodo());
        verify(perfilRepository, times(1)).save(any(PerfilUsuario.class));
    }
}
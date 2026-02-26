package com.eva.usuariosclaves.service;

import com.eva.usuariosclaves.dto.UsuarioDTO;
import com.eva.usuariosclaves.model.Proveedor;
import com.eva.usuariosclaves.model.Usuario;
import com.eva.usuariosclaves.repository.UsuarioRepository;
import com.eva.usuariosclaves.repository.ProveedorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private ProveedorRepository proveedorRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    void crearUsuario_deberiaGuardarYRetornarDTO() {

        Proveedor proveedor = new Proveedor();
        proveedor.setId(1L);
        proveedor.setNombreEmpresa("Empresa Test");

        Usuario usuarioGuardado = new Usuario();
        usuarioGuardado.setId(1L);
        usuarioGuardado.setNombre("Juan");
        usuarioGuardado.setEmail("juan@test.com");
        usuarioGuardado.setProveedor(proveedor);

        UsuarioDTO dto = new UsuarioDTO(
                null,
                "Juan",
                "juan@test.com",
                LocalDateTime.now(),
                "contrasenia",
                1L,
                null
        );

        when(proveedorRepository.findById(1L)).thenReturn(Optional.of(proveedor));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioGuardado);

        UsuarioDTO resultado = usuarioService.crearUsuario(dto);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
        assertEquals("Empresa Test", resultado.getProveedorNombre());

        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    void obtenerPorId_deberiaRetornarUsuarioDTO() {

        Proveedor proveedor = new Proveedor();
        proveedor.setId(1L);
        proveedor.setNombreEmpresa("Empresa");

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Ana");
        usuario.setEmail("ana@test.com");
        usuario.setProveedor(proveedor);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        UsuarioDTO resultado = usuarioService.obtenerPorId(1L);

        assertEquals("Ana", resultado.getNombre());
        assertEquals("Empresa", resultado.getProveedorNombre());

        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void eliminarUsuario_deberiaLlamarRepository() {

        usuarioService.eliminarUsuario(1L);

        verify(usuarioRepository, times(1)).deleteById(1L);
    }
}
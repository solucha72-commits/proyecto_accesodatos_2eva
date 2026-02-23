package com.eva.usuariosclaves.service;

import com.eva.usuariosclaves.dto.UsuarioDTO;
import com.eva.usuariosclaves.model.Proveedor;
import com.eva.usuariosclaves.model.Usuario;
import com.eva.usuariosclaves.repository.UsuarioRepository;
import com.eva.usuariosclaves.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ProveedorRepository proveedorRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              ProveedorRepository proveedorRepository) {
        this.usuarioRepository = usuarioRepository;
        this.proveedorRepository = proveedorRepository;
    }

//    @Override
//    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
//
//        Proveedor proveedor = proveedorRepository.findById(usuarioDTO.getProveedorId())
//                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
//
//        Usuario usuario = new Usuario();
//        usuario.setNombre(usuarioDTO.getNombre());
//        usuario.setEmail(usuarioDTO.getEmail());
//        usuario.setPassword(usuarioDTO.getPassword());
//        usuario.setProveedor(proveedor);
//
//        Usuario guardado = usuarioRepository.save(usuario);
//
//        return convertirADTO(guardado);
//    }


    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return convertirADTO(usuario);
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {

        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        existente.setNombre(usuarioDTO.getNombre());
        existente.setEmail(usuarioDTO.getEmail());

        Usuario actualizado = usuarioRepository.save(existente);

        return convertirADTO(actualizado);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setFechaCreacion(LocalDateTime.now());

        Usuario guardado = usuarioRepository.save(usuario);

        return new UsuarioDTO(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getEmail(),
                guardado.getFechaCreacion(),
                guardado.getPassword()
        );
    }

    private UsuarioDTO convertirADTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getFechaCreacion(),
                usuario.getPassword()
        );
    }

}
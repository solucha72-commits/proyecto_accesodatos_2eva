package com.eva.usuariosclaves.service;

import com.eva.usuariosclaves.dto.PerfilUsuarioDTO;
import com.eva.usuariosclaves.model.PerfilUsuario;
import com.eva.usuariosclaves.model.Usuario;
import com.eva.usuariosclaves.repository.PerfilUsuarioRepository;
import com.eva.usuariosclaves.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;

    public PerfilUsuarioServiceImpl(PerfilUsuarioRepository perfilRepository,
                                    UsuarioRepository usuarioRepository) {
        this.perfilRepository = perfilRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<PerfilUsuarioDTO> listar() {
        return perfilRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public PerfilUsuarioDTO obtenerPorId(Long id) {
        PerfilUsuario perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
        return convertirADTO(perfil);
    }

    @Override
    public PerfilUsuarioDTO guardar(PerfilUsuarioDTO perfilDTO) {

        Usuario usuario = usuarioRepository.findById(perfilDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setApodo(perfilDTO.getApodo());
        perfil.setUsuario(usuario);

        PerfilUsuario guardado = perfilRepository.save(perfil);

        return convertirADTO(guardado);
    }

    @Override
    public PerfilUsuarioDTO actualizar(Long id, PerfilUsuarioDTO perfilDTO) {

        PerfilUsuario existente = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        existente.setApodo(perfilDTO.getApodo());

        PerfilUsuario actualizado = perfilRepository.save(existente);

        return convertirADTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        perfilRepository.deleteById(id);
    }

    private PerfilUsuarioDTO convertirADTO(PerfilUsuario perfil) {
        return new PerfilUsuarioDTO(
                perfil.getId(),
                perfil.getApodo(),
                perfil.getUsuario().getId()
        );
    }
}
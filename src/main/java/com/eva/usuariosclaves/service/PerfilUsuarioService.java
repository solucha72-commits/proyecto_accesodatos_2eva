package com.eva.usuariosclaves.service;

import com.eva.usuariosclaves.dto.PerfilUsuarioDTO;
import java.util.List;

public interface PerfilUsuarioService {

    List<PerfilUsuarioDTO> listar();

    PerfilUsuarioDTO obtenerPorId(Long id);

    PerfilUsuarioDTO guardar(PerfilUsuarioDTO perfilDTO);

    PerfilUsuarioDTO actualizar(Long id, PerfilUsuarioDTO perfilDTO);

    void eliminar(Long id);
}
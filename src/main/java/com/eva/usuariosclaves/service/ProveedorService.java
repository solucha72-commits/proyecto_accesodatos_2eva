package com.eva.usuariosclaves.service;

import com.eva.usuariosclaves.dto.ProveedorDTO;
import java.util.List;

public interface ProveedorService {

    List<ProveedorDTO> listar();

    ProveedorDTO obtenerPorId(Long id);

    ProveedorDTO guardar(ProveedorDTO proveedorDTO);

    ProveedorDTO actualizar(Long id, ProveedorDTO proveedorDTO);

    void eliminar(Long id);
}
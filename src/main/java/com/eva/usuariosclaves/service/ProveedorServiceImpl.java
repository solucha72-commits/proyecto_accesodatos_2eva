package com.eva.usuariosclaves.service;

import com.eva.usuariosclaves.dto.ProveedorDTO;
import com.eva.usuariosclaves.model.Proveedor;
import com.eva.usuariosclaves.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<ProveedorDTO> listar() {
        return proveedorRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProveedorDTO obtenerPorId(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        return convertirADTO(proveedor);
    }

    @Override
    public ProveedorDTO guardar(ProveedorDTO proveedorDTO) {

        Proveedor proveedor = new Proveedor();
        proveedor.setNombreEmpresa(proveedorDTO.getNombreEmpresa());
        proveedor.setEmailContacto(proveedorDTO.getEmailContacto());
        proveedor.setTelefonoContacto(proveedorDTO.getTelefonoContacto());

        Proveedor guardado = proveedorRepository.save(proveedor);

        return convertirADTO(guardado);
    }

    @Override
    public ProveedorDTO actualizar(Long id, ProveedorDTO proveedorDTO) {

        Proveedor existente = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        existente.setNombreEmpresa(proveedorDTO.getNombreEmpresa());
        existente.setEmailContacto(proveedorDTO.getEmailContacto());
        existente.setTelefonoContacto(proveedorDTO.getTelefonoContacto());

        Proveedor actualizado = proveedorRepository.save(existente);

        return convertirADTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }

    private ProveedorDTO convertirADTO(Proveedor proveedor) {
        return new ProveedorDTO(
                proveedor.getId(),
                proveedor.getNombreEmpresa(),
                proveedor.getEmailContacto(),
                proveedor.getTelefonoContacto()
        );
    }
}
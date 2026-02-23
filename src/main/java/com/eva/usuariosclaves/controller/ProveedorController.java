package com.eva.usuariosclaves.controller;

import com.eva.usuariosclaves.dto.ProveedorDTO;
import com.eva.usuariosclaves.service.ProveedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<ProveedorDTO> listar() {
        return proveedorService.listar();
    }

    @GetMapping("/{id}")
    public ProveedorDTO obtenerPorId(@PathVariable Long id) {
        return proveedorService.obtenerPorId(id);
    }

    @PostMapping
    public ProveedorDTO crear(@RequestBody ProveedorDTO proveedorDTO) {
        return proveedorService.guardar(proveedorDTO);
    }

    @PutMapping("/{id}")
    public ProveedorDTO actualizar(@PathVariable Long id,
                                   @RequestBody ProveedorDTO proveedorDTO) {
        return proveedorService.actualizar(id, proveedorDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proveedorService.eliminar(id);
    }
}
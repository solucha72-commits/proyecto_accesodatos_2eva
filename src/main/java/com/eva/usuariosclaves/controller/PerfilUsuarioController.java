package com.eva.usuariosclaves.controller;

import com.eva.usuariosclaves.dto.PerfilUsuarioDTO;
import com.eva.usuariosclaves.service.PerfilUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilUsuarioController {

    private final PerfilUsuarioService perfilService;

    public PerfilUsuarioController(PerfilUsuarioService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping
    public List<PerfilUsuarioDTO> listar() {
        return perfilService.listar();
    }

    @GetMapping("/{id}")
    public PerfilUsuarioDTO obtenerPorId(@PathVariable Long id) {
        return perfilService.obtenerPorId(id);
    }

    @PostMapping
    public PerfilUsuarioDTO crear(@RequestBody PerfilUsuarioDTO perfilDTO) {
        return perfilService.guardar(perfilDTO);
    }

    @PutMapping("/{id}")
    public PerfilUsuarioDTO actualizar(@PathVariable Long id,
                                       @RequestBody PerfilUsuarioDTO perfilDTO) {
        return perfilService.actualizar(id, perfilDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        perfilService.eliminar(id);
    }
}
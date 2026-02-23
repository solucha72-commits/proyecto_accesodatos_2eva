package com.eva.usuariosclaves.dto;

public class PerfilUsuarioDTO {

    private Long id;
    private String apodo;
    private Long usuarioId;

    public PerfilUsuarioDTO() {}

    public PerfilUsuarioDTO(Long id, String apodo, Long usuarioId) {
        this.id = id;
        this.apodo = apodo;
        this.usuarioId = usuarioId;
    }

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public String getApodo() {
        return apodo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
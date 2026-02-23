package com.eva.usuariosclaves.dto;

import java.time.LocalDateTime;

public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String email;
    private LocalDateTime fechaCreacion;
    private String password;

    public UsuarioDTO() {}

    public UsuarioDTO(Long id, String nombre, String email,
                      LocalDateTime fechaCreacion, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
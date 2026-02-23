package com.eva.usuariosclaves.model;

import jakarta.persistence.*;

@Entity
@Table(name = "perfiles")
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String apodo;

    // 🔹 Relación 1:1 → lado dueño
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    public PerfilUsuario() {}

    public PerfilUsuario(String apodo, Usuario usuario) {
        this.apodo = apodo;
        this.usuario = usuario;
    }

    // Getters

    public Long getId() { return id; }
    public String getApodo() { return apodo; }
    public Usuario getUsuario() { return usuario; }

    // Setters

    public void setApodo(String apodo) { this.apodo = apodo; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
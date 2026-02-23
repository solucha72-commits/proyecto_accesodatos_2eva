package com.eva.usuariosclaves.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // 🔹 Relación N:1 → Usuario es el lado dueño
    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    // 🔹 Relación 1:1 → PerfilUsuario es el lado dueño
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PerfilUsuario perfil;

    public Usuario() {}

    public Usuario(String nombre, String email, String password, Proveedor proveedor) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.proveedor = proveedor;
        this.fechaCreacion = LocalDateTime.now();
    }

    // Getters

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public Proveedor getProveedor() { return proveedor; }
    public PerfilUsuario getPerfil() { return perfil; }

    // Setters

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }
    public void setPerfil(PerfilUsuario perfil) { this.perfil = perfil; }

    public void setId(long l) {
        this.id = l;
    }
}
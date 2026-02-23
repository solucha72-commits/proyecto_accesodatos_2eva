package com.eva.usuariosclaves.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreEmpresa;

    @Column(nullable = false)
    private String emailContacto;

    @Column(nullable = false)
    private String telefonoContacto;

    // 🔹 Relación 1:N → lado inverso
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    public Proveedor() {}

    public Proveedor(String nombreEmpresa, String emailContacto, String telefonoContacto) {
        this.nombreEmpresa = nombreEmpresa;
        this.emailContacto = emailContacto;
        this.telefonoContacto = telefonoContacto;
    }

    // Getters

    public Long getId() { return id; }
    public String getNombreEmpresa() { return nombreEmpresa; }
    public String getEmailContacto() { return emailContacto; }
    public String getTelefonoContacto() { return telefonoContacto; }
    public List<Usuario> getUsuarios() { return usuarios; }

    // Setters

    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
    public void setEmailContacto(String emailContacto) { this.emailContacto = emailContacto; }
    public void setTelefonoContacto(String telefonoContacto) { this.telefonoContacto = telefonoContacto; }
    public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }

    public void setId(long l) {
        this.id = l;
    }
}
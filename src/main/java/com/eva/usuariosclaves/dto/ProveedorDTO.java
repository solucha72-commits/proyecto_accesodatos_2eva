package com.eva.usuariosclaves.dto;

public class ProveedorDTO {

    private Long id;
    private String nombreEmpresa;
    private String emailContacto;
    private String telefonoContacto;

    public ProveedorDTO() {}

    public ProveedorDTO(Long id, String nombreEmpresa,
                        String emailContacto,
                        String telefonoContacto) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.emailContacto = emailContacto;
        this.telefonoContacto = telefonoContacto;
    }

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}
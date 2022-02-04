package com.example.demofacturas.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FAC_CLIENTES")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLI_ID",unique = true, nullable = false, length = 20)
    private String id;
    @Column(name="CLI_NOMBRE", nullable = true, length = 100)
    private String nombre;
    @Column(name="CLI_DIRECCION", nullable = true, length = 100)
    private String direccion;
    @Column(name="CLI_TIPO_DOCUMENTO", nullable = true, length = 20)
    private String tipoDocumento;
    @Column(name="CLI_NUMERO_DOCUMENTO", nullable = true, length = 20)
    private String numeroDocumento;
    @Column(name="CLI_EMAIL", nullable = true, length = 50)
    private String email;
    @Column(name="CLI_CELULAR", nullable = true, length = 20)
    private String celular;
    @Column(name="CLI_NOMBRE_EMPRESA", nullable = true, length = 50)
    private String nombreEmpresa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }



}

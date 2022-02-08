/*
 * @(#)Cliente.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */


package com.example.demofacturas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * Esta clase representa a un cliente y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 04/02/2022
 *
 **/

@Entity
@Table(name = "FAC_CLIENTES")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "CLI_ID",unique = true, nullable = false, length = 20)
    /** Identificardor del cliente*/
    private String id;

    @Column(name="CLI_NOMBRE", nullable = true, length = 100)
    /** Nombre del cliente*/
    private String nombre;

    @Column(name="CLI_DIRECCION", nullable = true, length = 100)
    /** Direccion del cliente*/
    private String direccion;

    @Column(name="CLI_TIPO_DOCUMENTO", nullable = true, length = 20)
    /** Tipo de DOcumento del cliente*/
    private String tipoDocumento;

    @Column(name="CLI_NUMERO_DOCUMENTO", nullable = true, length = 20)
    /** Numero de Doucmento del cliente*/
    private String numeroDocumento;

    @Column(name="CLI_EMAIL", nullable = true, length = 50)
    /** Email del cliente*/
    private String email;

    @Column(name="CLI_CELULAR", nullable = true, length = 20)
    /** Celular del cliente*/
    private String celular;

    @Column(name="CLI_NOMBRE_EMPRESA", nullable = true, length = 50)
    /** Nombre de Empresa del cliente*/
    private String nombreEmpresa;

    /** Obtiene el identificador de este cliente */
    public String getId() {
        return id;
    }

    /** Establece el identificador de este cliente */
    public void setId(String id) {
        this.id = id;
    }

    /** Obtiene el nombre de este cliente */
    public String getNombre() {
        return nombre;
    }

    /** Establece el nombre de este cliente */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Obtiene la direccion de este cliente */
    public String getDireccion() {
        return direccion;
    }

    /** Establece la direccion de este cliente */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /** Obtiene el tipo de documento de este cliente */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /** Establece el tipo de documento de este cliente */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /** Obtiene el numero de documento de este cliente */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /** Establece el numero de documento de este cliente */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /** Obtiene el email de este cliente */
    public String getEmail() {
        return email;
    }

    /** Establece el email de este cliente */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Obtiene el celular de este cliente */
    public String getCelular() {
        return celular;
    }

    /** Establece el celular de este cliente */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /** Obtiene el nombre de la empresa de este cliente */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /** Establece el nombre de la empresa de este cliente */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

}

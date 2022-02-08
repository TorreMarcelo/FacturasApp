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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Esta clase representa a un producto y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 04/02/2022
 *
 */

@Entity
@Table(name = "FAC_PRODUCTOS")
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRO_ID",unique = true, nullable = false, length = 50)
    /** Identificardor del producto*/
    private String id;

    @Column(name="PRO_NOMBRE", nullable = true, length = 100)
    /** Nombre del producto*/
    private String nombre;

    @Column(name="PRO_PRECIO_UNITARIO",precision = 7, scale = 2, nullable = true )
    /** Precio unitario del producto*/
    private BigDecimal precioUnitario;

    /** Obtiene el identificador de este producto */
    public String getId() {
        return id;
    }

    /** Establece el identificador de este producto */
    public void setId(String id) {
        this.id = id;
    }

    /** Obtiene el nombre de este producto */
    public String getNombre() {
        return nombre;
    }

    /** Establece el nombre de este producto */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Obtiene el precio unitario de este producto */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /** Establece el precio unitario de este producto */
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}

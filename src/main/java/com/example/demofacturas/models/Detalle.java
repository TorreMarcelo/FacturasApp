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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

 /**
  * Esta clase representa a un detalle y debe ser usada para almacenar
  * datos e intercambiarlos con otros objetos.
  *
  * @author Carlos Torre
  * @version 1, 04/02/2022
  *
  */
@Entity
@Table(name = "FAC_PRODUCTOS_FACTURAS")
@NoArgsConstructor
@AllArgsConstructor
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PFACT_ID",unique = true, nullable = false, length = 50)
    /** Identificardor del detalle*/
    private String id;

    @Column(name="PFACT_CANTIDAD", nullable = true)
    /** Cantidad de unidades del detalle*/
    private int cantidad;

    @Column(name="PFACT_IMPORTE", precision = 7, scale = 2, nullable = true)
    /** Importe del detalle*/
    private BigDecimal importe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PFACT_PRO_ID", nullable = false)
    /** Prducto incluido en el detalle*/
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PFACT_FAC_ID", nullable = false)
    /** Factura a la que pertenece el detalle*/
    private Factura factura;

    /** Obtiene el identificador de este detalle */
    public String getId() {
        return id;
    }

    /** Establece el identificador de este detalle */
    public void setId(String id) {
        this.id = id;
    }

    /** Obtiene la cantidad de unidades de este detalle */
    public int getCantidad() {
        return cantidad;
    }

    /** Establece la cantidad de unidades de este detalle */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /** Obtiene el importe de este detalle */
    public BigDecimal getImporte() {
        return importe;
    }

    /** Establece el importe de este detalle */
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    /** Obtiene el Producto de este detalle */
    public Producto getProducto() {
        return producto;
    }

    /** Establece el Producto de este detalle */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /** Obtiene la factura correspondiente a este detalle */
    public Factura getFactura() {
        return factura;
    }

    /** Establece la factura correspondiente a este detalle */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}

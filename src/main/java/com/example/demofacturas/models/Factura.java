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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * Esta clase representa a una factura y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 04/02/2022
 *
 */
@Entity
@Table(name = "FAC_FACTURAS")
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "FACT_ID",unique = true, nullable = false, length = 50)
    /** Numero identificador de la factura*/
    private String numeroId;

    @Column(name="FACT_DIRECCION", nullable = true, length = 100)
    /** Direccion de la factura*/
    private String direccion;

    @Column(name="FACT_FECHA_EMISION", nullable = true)
    /** Fecha de Emision de la factura*/
    private LocalDate fechaEmision;

    @Column(name="FACT_FECHA_PAGO", nullable = true)
    /** Fecha de Pago de la factura*/
    private LocalDate fechaPago;

    @Column(name="FACT_TIPO_PAGO", nullable = true, length = 20)
    /** Tipo de pago de la factura*/
    private String tipoPago;

    @Column(name="FACT_ESTADO", nullable = true, length = 1)
    /** Estado de la factura*/
    private char estado;

    @Column(name="FACT_IMPORTE_TOTAL", precision = 7, scale = 2, nullable = true)
    /** Importe total de la factura*/
    private BigDecimal importeTotal;

    @Column(name="FACT_IMPUESTO", precision = 7, scale = 2, nullable = true)
    /** Impuesto de la factura*/
    private BigDecimal impuesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FACT_CLI_ID", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    /** Cliente a quien va dirigida la factura*/
    private Cliente cliente;

    @OneToMany
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    /** Lista de detalles de la factura*/
    private List<Detalle> detalles;

    /** Obtiene el numero de identificacion de esta factura */
    public String getNumeroId() {
        return numeroId;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }

    /** Obtiene la direccion de esta factura */
    public String getDireccion() {
        return direccion;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /** Obtiene la fecha de emision de esta factura */
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /** Obtiene la fecha de pago de esta factura */
    public LocalDate getFechaPago() {
        return fechaPago;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    /** Obtiene el tipo de pago de esta factura */
    public String getTipoPago() {
        return tipoPago;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    /** Obtiene el estado de esta factura */
    public char getEstado() {
        return estado;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setEstado(char estado) {
        this.estado = estado;
    }

    /** Obtiene el importe de esta factura */
    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    /** Obtiene el impuesto de esta factura */
    public BigDecimal getImpuesto() {
        return impuesto;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    /** Obtiene el cliente a quien va dirigida esta factura */
    public Cliente getCliente() {
        return cliente;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /** Obtiene los deatlles de este factura */
    public List<Detalle> getDetalles() {
        return detalles;
    }

    /** Establece el numero de identificacion de esta factura */
    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
}

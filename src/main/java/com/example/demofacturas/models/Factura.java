package com.example.demofacturas.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "FAC_FACTURAS")
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FACT_ID",unique = true, nullable = false, length = 50)
    private String numeroId;
    @Column(name="FACT_DIRECCION", nullable = true, length = 100)
    private String direccion;
    @Column(name="FACT_FECHA_EMISION", nullable = true)
    private LocalDate fechaEmision;
    @Column(name="FACT_FECHA_PAGO", nullable = true)
    private LocalDate fechaPago;
    @Column(name="FACT_TIPO_PAGO", nullable = true, length = 20)
    private String tipoPago;
    @Column(name="FACT_ESTADO", nullable = true, length = 1)
    private char estado;
    @Column(name="FACT_IMPORTE_TOTAL", precision = 7, scale = 2, nullable = true)
    private BigDecimal importeTotal;
    @Column(name="FACT_IMPUESTO", precision = 7, scale = 2, nullable = true)
    private BigDecimal impuesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FACT_CLI_ID", nullable = false)
    private Cliente cliente;

    @OneToMany
    private List<Detalle> detalles;



    public String getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
}

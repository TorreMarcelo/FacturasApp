/*
 * @(#)Cliente.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.example.demofacturas.services;

import com.example.demofacturas.dtos.DetalleFactura;
import com.example.demofacturas.models.Detalle;
import com.example.demofacturas.models.Factura;

import java.math.BigDecimal;
import java.util.List;

/**
 * Esta clase representa al Servicio de Detalle y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 09/02/2022
 *
 */
public interface DetalleServicio {

    List<Detalle> listarDetalles();

    Detalle registrarDetalle(Detalle detalle);

    BigDecimal crearDetalle (Factura factura, List<DetalleFactura> detalles);

}

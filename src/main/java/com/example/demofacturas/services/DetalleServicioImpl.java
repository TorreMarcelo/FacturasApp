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

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.demofacturas.dtos.DetalleFactura;
import com.example.demofacturas.exception.ZyTrustException;
import com.example.demofacturas.models.Factura;
import com.example.demofacturas.models.Producto;
import com.example.demofacturas.util.CodigoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demofacturas.models.Detalle;
import com.example.demofacturas.repositories.DetalleRepositorio;

/**
 * Esta clase representa a la implementacion Servicio de Detalle
 * y debe ser usada para almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 09/02/2022
 *
 */
@Service
public class DetalleServicioImpl implements DetalleServicio {

    @Autowired
    /** Repositorio de detalle con inyeccion de dependencia */
    DetalleRepositorio detalleRepositorio;

    @Autowired
    ProductoServicio productoServicio;

    /**
    * Obtiene todas los detalles y las agrega a una lista.
    *
    * @return Retorna una lista Detalle de todos los detalles
    */
    public List<Detalle> listarDetalles(){
        return detalleRepositorio.findAll();
    }

    /**
     * Crea un nuevo detalle.
     *
     * @param detalle objeto detalle para su creacion
     * @return Retorna un objeto detalle
     */
    public Detalle registrarDetalle(Detalle detalle){
        return detalleRepositorio.save(detalle);
    }


    public BigDecimal crearDetalle (Factura factura, List<DetalleFactura> detalles){

        BigDecimal subtotal = new BigDecimal("0.00");

        for (DetalleFactura detalle : detalles) {

            Optional<Producto> prod = productoServicio.getById(detalle.getProductoId());

            if (prod.isEmpty()) {
                //logger.info("No se encontro el producto con el id {}", detalle.getProductoId());
                throw new ZyTrustException(CodigoError.PRODUCTO_NO_ExISTE);
            }

            Producto producto = prod.get();

            Detalle detalledCreado= Detalle.builder()
                    .factura(factura)
                    .producto(producto)
                    //.facturaId(factura.getFacturaId())
                    //.productoId(producto.getProductoId())
                    .cantidad(detalle.getCantidad())
                    .importe(producto.getPrecioUnitario().multiply(BigDecimal.valueOf(detalle.getCantidad())))
                    .build();

            detalleRepositorio.save(detalledCreado);
            //logger.debug("Se creo el detalle {}", detalleFactura.toString());
            subtotal = subtotal.add(detalledCreado.getImporte()).stripTrailingZeros();
        }
        return subtotal;



    }


}

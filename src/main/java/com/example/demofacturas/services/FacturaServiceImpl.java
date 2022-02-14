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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demofacturas.dtos.DetalleFactura;
import com.example.demofacturas.dtos.FacturaRequest;
import com.example.demofacturas.exception.ZyTrustException;
import com.example.demofacturas.models.Cliente;
import com.example.demofacturas.models.Detalle;
import com.example.demofacturas.util.CodigoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demofacturas.models.Factura;
import com.example.demofacturas.repositories.FacturaRepository;
import org.springframework.transaction.annotation.Transactional;

 /**
  * Esta clase representa al Servicio de Factura y debe ser usada para almacenar
  * datos e intercambiarlos con otros objetos.
  *
  * @author Carlos Torre
  * @version 1, 07/02/2022
  *
  */
@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    /** Repositorio de factura con inyeccion de dependencia */
    FacturaRepository facturaRepository;

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    DetalleServicio detalleServicio;

    /**
    * Obtiene todas las facturas y las agrega a una lista.
    *
    * @return Retorna una lista Factura de todas las facturas
    */
    @Override
    @Transactional(readOnly = true)
    public List<Factura> listarFacturas(){
        return facturaRepository.findAll();
    }

    /**
    * Crea una nueva factura.
    *
    * @param factura objeto factura para su creacion
    * @return Retorna un objeto factura
    */
    @Override
    @Transactional
    public Factura registrarFactura(Factura factura){
        return facturaRepository.save(factura);
    }




    public Factura crearFactura(FacturaRequest facturaRequest) {

        Optional<Cliente> cliente = clienteServicio.getById(facturaRequest.getIdCliente());
        if (cliente.isEmpty()){
            throw new ZyTrustException(CodigoError.CLIENTE_NO_EXISTE);
        }


        //build factura
        Factura facturaVacia = Factura
                .builder()
                .cliente(cliente.get())
                .fechaEmision(LocalDate.now())
                .fechaPago(LocalDate.now())
                .estado('R')
                .impuesto(new BigDecimal(0.00))
                //.detalles(detalles)
                .build();

        //factura.setDetalles(detalles);

        //datalles request
        List<DetalleFactura> detallesRequest = new ArrayList<>();

        //Lista de detalles
        List<Detalle> detalles = new ArrayList<>();
        facturaVacia.setSubtotal(detalleServicio.crearDetalle(facturaVacia, detallesRequest));

        facturaVacia.setImpuesto(facturaVacia.getSubtotal().multiply(new BigDecimal(0.18)));

        facturaVacia.setImporteTotal(facturaVacia.getSubtotal().add(facturaVacia.getImpuesto()));

        Factura facturaGuardada = facturaRepository.save(facturaVacia);

        return facturaGuardada;


    }

}

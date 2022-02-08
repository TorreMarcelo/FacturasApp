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

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demofacturas.models.Factura;
import com.example.demofacturas.repositories.FacturaRepository;

 /**
  * Esta clase representa al Servicio de Factura y debe ser usada para almacenar
  * datos e intercambiarlos con otros objetos.
  *
  * @author Carlos Torre
  * @version 1, 07/02/2022
  *
  */
@Service
public class FacturaService {

    @Autowired
    /** Repositorio de factura con inyeccion de dependencia */
    FacturaRepository facturaRepository;

    /**
    * Obtiene todas las facturas y las agrega a una lista.
    *
    * @return Retorna una lista Factura de todas las facturas
    */
    public List<Factura> listarFacturas(){
        return facturaRepository.findAll();
    }

    /**
    * Crea una nueva factura.
    *
    * @param factura objeto factura para su creacion
    * @return Retorna un objeto factura
    */
    public Factura registrarFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    public Optional<Factura> listarPorId(String numeroId){
        return facturaRepository.findById(numeroId);
    }

    public List<Factura> listarPorClienteId(String id){
        return facturaRepository.findByCliente(id);
    }


}

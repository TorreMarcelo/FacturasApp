 /*
  * @(#)Cliente.java
  *
  * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
  * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
  * términos de la licencia adquirida a ZyTrust SA.
  * No se permite modificar, copiar ni difundir sin autorización
  * expresa de ZyTrust SA.
  */

package com.example.demofacturas.controllers;

import java.net.URI;
import java.util.List;

import com.example.demofacturas.dtos.FacturaRequest;
import com.example.demofacturas.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demofacturas.models.Factura;

 /**
  * Esta clase representa al Controlodaor de Factura y debe ser usada para almacenar
  * datos e intercambiarlos con otros objetos.
  *
  * @author Carlos Torre
  * @version 1, 07/02/2022
  *
  */
@RestController
@RequestMapping("/facturas/")
public class FacturaController {

    @Autowired
    /** Controlador de factura con inyeccion de dependencia */
    FacturaService facturaService;

    /**
    * Obtiene todas las facturas y las agrega a una lista.
    *
    * @return Retorna un ResponseEntity con lal ista de todas las facturas
    */
    @GetMapping()
    public ResponseEntity<List<Factura>> listarFacturas(){
        return ResponseEntity.ok(facturaService.listarFacturas());
    }

    /**
    * Crea una nueva factura.
    *
    * @param /*factura objeto factura para su creacion
    * @return Retorna un objeto factura
    * @throws Exception excepcion basica durante la creacion de la factura
    */
    /*@PostMapping
    private ResponseEntity<Factura> registrarFactura (@RequestBody Factura factura){
        try {
            Factura facturaCreada = facturaService.registrarFactura(factura);
            return ResponseEntity.created(new URI("/facturas/"+facturaCreada.getNumeroId())).body(facturaCreada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }*/

    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody FacturaRequest facturaReq) {
        try {
            Factura facturaCompleta = facturaService.crearFactura(facturaReq);
            return ResponseEntity.created(new URI("/facturas/"+facturaCompleta.getNumeroId())).body(facturaCompleta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



}

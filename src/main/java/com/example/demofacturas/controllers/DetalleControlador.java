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

import com.example.demofacturas.services.DetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demofacturas.models.Detalle;


/**
 * Esta clase representa al Controlodaor de Detalle y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 08/02/2022
 *
 */
@RestController
@RequestMapping("/detalles/")
public class DetalleControlador {

    @Autowired
    /** Controlador de factura con inyeccion de dependencia */
    DetalleServicio detalleServicio;

    /**
     * Obtiene todas las detalles y las agrega a una lista.
     *
     * @return Retorna un ResponseEntity con una lista de todos los detalles
     */
    @GetMapping()
    public ResponseEntity<List<Detalle>> listarDetalles(){
        return ResponseEntity.ok(detalleServicio.listarDetalles());
    }

    /**
    * Crea un nuevo detalle.
    *
    * @param detalle objeto detalle para su creacion
    * @return Retorna un objeto detalle
    * @throws Exception excepcion basica durante la creacion del detalle.
    */
    @PostMapping
    private ResponseEntity<Detalle> registrarDetalle (@RequestBody Detalle detalle){
        try {
            Detalle detalleCreado = detalleServicio.registrarDetalle(detalle);
            return ResponseEntity.created(new URI("/detalles/"+detalleCreado.getId())).body(detalleCreado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

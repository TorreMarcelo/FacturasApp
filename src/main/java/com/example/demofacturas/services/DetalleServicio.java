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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demofacturas.models.Detalle;
import com.example.demofacturas.repositories.DetalleRepositorio;

/**
 * Esta clase representa al Servicio de Detalle y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 08/02/2022
 *
 */
@Service
public class DetalleServicio {

    @Autowired
    /** Repositorio de detalle con inyeccion de dependencia */
    DetalleRepositorio detalleRepositorio;

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
}

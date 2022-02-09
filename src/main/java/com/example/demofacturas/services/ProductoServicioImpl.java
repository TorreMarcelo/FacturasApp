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

import com.example.demofacturas.models.Producto;
import com.example.demofacturas.repositories.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta clase representa a la implemntacion de Servicio de Producto
 * y debe ser usada para almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 09/02/2022
 *
 */
@Service
public class ProductoServicioImpl implements ProductoServicio{

    @Autowired
    ProductoRepositorio productoRepositorio;

    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
    }

    public Producto crearProducto(Producto producto){
        return productoRepositorio.save(producto);
    }

}

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

import com.example.demofacturas.models.Producto;
import com.example.demofacturas.services.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


/**
 * Esta clase representa al Controlodor de Producto y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 09/02/2022
 *
 */

@RestController
@RequestMapping("/productos/")
public class ProductoControlador {

    ProductoServicio productoServicio;

    @GetMapping()
    public ResponseEntity<List<Producto>> listarProductos(){
        return ResponseEntity.ok(productoServicio.listarProductos());
    }

    @PostMapping
    private ResponseEntity<Producto> crearCliente (@RequestBody Producto producto){
        try {
            Producto producoCreado = productoServicio.crearProducto(producto);
            return ResponseEntity.created(new URI("/clientes/" + producoCreado.getId())).body(producoCreado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}

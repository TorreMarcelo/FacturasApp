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

import com.example.demofacturas.models.Cliente;
import com.example.demofacturas.services.ClienteServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Esta clase representa al Controlodor de Cliente y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 09/02/2022
 *
 */

@RestController
@RequestMapping("/clientes/")
public class ClienteControlador {

    ClienteServicio clienteServicio;

    @GetMapping()
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.ok(clienteServicio.listarClientes());
    }


    @PostMapping
    private ResponseEntity<Cliente> crearCliente (@RequestBody Cliente cliente){
        try {
            Cliente clienteCreado = clienteServicio.crearCliente(cliente);
            return ResponseEntity.created(new URI("/clientes/" + clienteCreado.getId())).body(clienteCreado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}

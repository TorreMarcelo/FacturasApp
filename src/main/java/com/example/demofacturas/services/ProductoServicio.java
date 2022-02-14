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

import java.util.List;
import java.util.Optional;

/**
 * Esta clase representa al Servicio de Producto y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 09/02/2022
 *
 */

public interface ProductoServicio {

    List<Producto> listarProductos();

    Producto crearProducto(Producto producto);

    Optional<Producto> getById(String id);

}

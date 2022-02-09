/*
 * @(#)Cliente.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */

package com.example.demofacturas.repositories;

import com.example.demofacturas.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase representa al Reposotorio de Producto y debe ser usada
 * para almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 09/02/2022
 *
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String> {
}

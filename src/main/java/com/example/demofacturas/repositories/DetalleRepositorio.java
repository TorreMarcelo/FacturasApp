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

/**
 * Esta clase representa al Repositorio de Detalle y debe ser usada para
 * alamcenar datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 08/02/2022
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demofacturas.models.Detalle;


@Repository
public interface DetalleRepositorio extends JpaRepository<Detalle, String> {
}

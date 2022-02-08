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

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demofacturas.models.Factura;

 /**
  * Esta clase representa al Repositorio de Factura y debe ser usada para
  * alamcenar datos e intercambiarlos con otros objetos.
  *
  * @author Carlos Torre
  * @version 1, 07/02/2022
  *
  */
@Repository
public interface FacturaRepository extends JpaRepository<Factura,String> {

    public abstract List<Factura> findByCliente(String id);
}

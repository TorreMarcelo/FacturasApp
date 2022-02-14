package com.example.demofacturas.repositories;

import com.example.demofacturas.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Esta clase representa al Reposotorio de Cliente y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Carlos Torre
 * @version 1, 09/02/2022
 *
 */

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

    //public abstract Optional<Cliente> getById(String id);
}

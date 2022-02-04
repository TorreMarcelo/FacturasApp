package com.example.demofacturas.repositories;

import com.example.demofacturas.models.Factura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends CrudRepository<Factura,String> {



}

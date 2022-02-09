package com.example.demofacturas.services;

import com.example.demofacturas.models.Factura;

import java.util.List;

public interface FacturaService {

    List<Factura> listarFacturas();

    Factura registrarFactura(Factura factura);
}

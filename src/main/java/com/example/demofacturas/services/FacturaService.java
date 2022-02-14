package com.example.demofacturas.services;

import com.example.demofacturas.dtos.FacturaRequest;
import com.example.demofacturas.models.Factura;

import java.util.List;

public interface FacturaService {

    List<Factura> listarFacturas();

    Factura registrarFactura(Factura factura);

    Factura crearFactura(FacturaRequest facturaRequest);
}

package com.example.demofacturas.util;

public enum CodigoError {

    CLIENTE_NO_EXISTE("El cliente con el id indicado no existe"),

    PRODUCTO_NO_ExISTE("E cliente seleccionado no existe"),

    PROBLEMAS_ALMACENAR_FACTURA("Se ha presentado un problema al almacenar la factura");

    private final String descripcion;

    CodigoError(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}

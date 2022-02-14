package com.example.demofacturas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer cantidad;

    private String productoId;
}

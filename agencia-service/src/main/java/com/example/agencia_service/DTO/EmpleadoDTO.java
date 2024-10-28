package com.example.agencia_service.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EmpleadoDTO implements Serializable {

    private Long legajo;
    private String nombre;
    private String apellido;
    private int telefono;

}
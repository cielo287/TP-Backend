package com.example.agencia_service.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class PruebaRequestDTO implements Serializable {
    private int vehiculoID;
    private int interesadoID;
    private int empleadoLegajo;
    }

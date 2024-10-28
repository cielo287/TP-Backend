package com.example.agencia_service.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class PosicionesDTO implements Serializable {

    private int id;
    private int idVehiculo;
    private String fechaHora;
    private int latitud;
    private int longitud;

}


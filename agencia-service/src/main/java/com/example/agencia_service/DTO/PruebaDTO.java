package com.example.agencia_service.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PruebaDTO implements Serializable {

    private int id;
    private int vehiculoID;
    private int interesadoID;
    private int empleadoLegajo;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String comentarios;

}

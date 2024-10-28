package com.example.agencia_service.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class VehiculoDTO implements Serializable {

    private int id;
    private String patente;
    private int idModelo;
    private List<PruebaDTO> pruebas;

}

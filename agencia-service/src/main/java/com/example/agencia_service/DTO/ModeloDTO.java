package com.example.agencia_service.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ModeloDTO implements Serializable {

    private int id;
    private int idMarca;
    private String descripcion;

}


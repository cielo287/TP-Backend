package com.example.agencia_service.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class InteresadoDTO implements Serializable {
    private int id;
    private String tipoDocumento;
    private String documento;
    private String nombre;
    private String apellido;
    private boolean restringido;
    private int nroLicencia;
    private LocalDate fechaVencimientoLicencia;

}

package com.example.agencia_service.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity(name = "Interesados")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Interesado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Column(name = "DOCUMENTO")
    private String documento;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "RESTRINGIDO")
    private boolean restringido;
    @Column(name = "NRO_LICENCIA")
    private int nroLicencia;
    @Column(name = "FECHA_VENCIMIENTO_LICENCIA")
    private LocalDate fechaVencimientoLicencia;

    @OneToMany(mappedBy = "interesado")
    @JsonBackReference
    private List<Prueba> pruebas; // Relación con Prueba





}

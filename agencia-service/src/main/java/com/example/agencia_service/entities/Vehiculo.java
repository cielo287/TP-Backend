package com.example.agencia_service.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Vehiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "PATENTE")
    private String patente;
    @Column(name = "ID_MODELO")
    private int idModelo;

    @OneToMany(mappedBy = "vehiculo")
    @JsonBackReference
    private List<Prueba> pruebas; // Relación con Prueba




}

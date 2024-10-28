package com.example.agencia_service.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity(name = "Empleados")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEGAJO")
    private int legajo;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "TELEFONO_CONTACTO")
    private int telefono;

    @OneToMany(mappedBy = "empleado")
    @JsonBackReference
    private List<Prueba> pruebas; // Relación con Prueba




}

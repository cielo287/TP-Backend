package com.example.agencia_service.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Modelos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID")
    private Marca marca;
    @Column(name = "DESCRIPCION")
    private String descripcion;



}

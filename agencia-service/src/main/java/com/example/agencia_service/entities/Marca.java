package com.example.agencia_service.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Marcas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "marca")
    private List<Modelo> modelos;





}

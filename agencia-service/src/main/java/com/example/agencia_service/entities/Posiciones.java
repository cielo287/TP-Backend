package com.example.agencia_service.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Posiciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posiciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn (name = "ID_VEHICULO", referencedColumnName = "ID", nullable = false)
    private Vehiculo vehiculo;
    @Column (name = "FECHA_HORA")
    private String FechaHora;
    @Column (name = "LATITUD")
    private int latitud;
    @Column (name = "LONGITUD")
    private int longitud;





}

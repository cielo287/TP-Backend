package com.example.agencia_service.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Pruebas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column (name = "FECHA_HORA_INICIO")
    private LocalDateTime fechaHoraInicio;
    @Column (name = "FECHA_HORA_FIN")
    private LocalDateTime fechaHoraFin;
    @Column (name = "COMENTARIOS")
    private String comentarios;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "LEGAJO", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ID_INTERESADO", referencedColumnName = "ID", nullable = false)
    private Interesado interesado;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "ID", nullable = false)
    private Vehiculo vehiculo;




}

package com.example.agencia_service.controllers;


import com.example.agencia_service.DTO.InteresadoDTO;
import com.example.agencia_service.DTO.PruebaDTO;
import com.example.agencia_service.DTO.PruebaRequestDTO;
import com.example.agencia_service.entities.Empleado;
import com.example.agencia_service.entities.Interesado;
import com.example.agencia_service.entities.Prueba;
import com.example.agencia_service.entities.Vehiculo;
import com.example.agencia_service.service.EmpleadoService;
import com.example.agencia_service.service.InteresadoService;
import com.example.agencia_service.service.PruebaService;
import com.example.agencia_service.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pruebas")
public class PruebaController {

    private final PruebaService pruebaService;
    private final EmpleadoService empleadoService;
    private final InteresadoService interesadoService;
    private final VehiculoService vehiculoService;


    @Autowired
    public PruebaController(PruebaService pruebaService, EmpleadoService empleadoService,
                            InteresadoService interesadoService, VehiculoService vehiculoService) {
        this.pruebaService = pruebaService;
        this.empleadoService = empleadoService;
        this.interesadoService = interesadoService;
        this.vehiculoService = vehiculoService;
    }
    @PostMapping("/iniciar")
    public ResponseEntity<PruebaDTO> iniciarPrueba(@RequestBody PruebaDTO pruebaDTO) {
        Interesado interesado = interesadoService.obtenerInteresadoPorId(pruebaDTO.getInteresadoID());
        Empleado empleado = empleadoService.obtenerEmpleadoPorLegajo(pruebaDTO.getEmpleadoLegajo());
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(pruebaDTO.getVehiculoID());

        LocalDateTime fechaHoraInicio = pruebaDTO.getFechaHoraInicio();
        String comentario = pruebaDTO.getComentarios();





        Prueba prueba = pruebaService.iniciarPrueba(interesado, empleado, vehiculo, fechaHoraInicio, comentario);



        pruebaDTO.setId(prueba.getId());
        pruebaDTO.setInteresadoID(interesado.getId().intValue());
        pruebaDTO.setEmpleadoLegajo(empleado.getLegajo());
        pruebaDTO.setVehiculoID(vehiculo.getId());
        pruebaDTO.setFechaHoraInicio(prueba.getFechaHoraInicio());
        pruebaDTO.setFechaHoraFin(prueba.getFechaHoraFin());
        pruebaDTO.setComentarios(prueba.getComentarios());

        return ResponseEntity.status(HttpStatus.CREATED).body(pruebaDTO);
    }
    /*@GetMapping("/en-curso")
    public ResponseEntity<List<Prueba>> listarPruebasEnCurso() {
        List<Prueba> pruebasEnCurso = pruebaService.listarPruebasEnCurso();

        if (pruebasEnCurso.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pruebasEnCurso);
    }*/
    @GetMapping("/en-curso")
    public ResponseEntity<List<Prueba>> listarPruebasEnCurso() {
        List<Prueba> pruebasEnCurso = pruebaService.listarPruebasEnCurso(); // Lanzará EntityNotFoundException si no se encuentra nada

        return ResponseEntity.ok(pruebasEnCurso);
    }

    @PutMapping("/finalizar")
    public ResponseEntity<PruebaDTO> finalizarPrueba(@RequestBody PruebaDTO pruebaDTO) {
        // Obtener datos necesarios del DTO
        int idPrueba = pruebaDTO.getId();
        LocalDateTime fechaHoraFin = pruebaDTO.getFechaHoraFin();
        String comentario = pruebaDTO.getComentarios();

        // Llamar al servicio para finalizar la prueba con el ID dado
        Prueba prueba = pruebaService.finalizarPrueba(fechaHoraFin, idPrueba, comentario);

        // Actualizar el DTO con los valores finales de la prueba
        pruebaDTO.setId(prueba.getId());
        pruebaDTO.setInteresadoID(prueba.getInteresado().getId().intValue());
        pruebaDTO.setEmpleadoLegajo(prueba.getEmpleado().getLegajo());
        pruebaDTO.setVehiculoID(prueba.getVehiculo().getId());
        pruebaDTO.setFechaHoraInicio(prueba.getFechaHoraInicio());
        pruebaDTO.setFechaHoraFin(prueba.getFechaHoraFin());
        pruebaDTO.setComentarios(prueba.getComentarios());

        // Devolver el DTO actualizado con estado HTTP 200 (OK)
        return ResponseEntity.ok(pruebaDTO);
    }



}




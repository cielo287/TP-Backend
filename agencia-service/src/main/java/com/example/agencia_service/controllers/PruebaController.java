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
        LocalDateTime fechaHoraFin = pruebaDTO.getFechaHoraFin();


        Prueba prueba = pruebaService.iniciarPrueba(interesado, empleado, vehiculo, fechaHoraInicio, fechaHoraFin);



        pruebaDTO.setId(prueba.getId());
        pruebaDTO.setInteresadoID(interesado.getId().intValue());
        pruebaDTO.setEmpleadoLegajo(empleado.getLegajo());
        pruebaDTO.setVehiculoID(vehiculo.getId());
        pruebaDTO.setFechaHoraInicio(prueba.getFechaHoraInicio());
        pruebaDTO.setFechaHoraFin(prueba.getFechaHoraFin());
        pruebaDTO.setComentarios(prueba.getComentarios());

        return ResponseEntity.status(HttpStatus.CREATED).body(pruebaDTO);
    }
    @GetMapping("/en-curso")
    public ResponseEntity<List<Prueba>> listarPruebasEnCurso(@RequestParam("fechaHora") LocalDateTime fechaHora) {
        List<Prueba> pruebasEnCurso = pruebaService.listarPruebasEnCurso(fechaHora);

        if (pruebasEnCurso.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pruebasEnCurso);
    }
}




package com.example.agencia_service.controllers;


import com.example.agencia_service.DTO.InteresadoDTO;
import com.example.agencia_service.entities.Interesado;
import com.example.agencia_service.service.EmpleadoService;
import com.example.agencia_service.service.InteresadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interesados")
public class InteresadoController {

    private final InteresadoService interesadoService;

    @Autowired
    public InteresadoController(InteresadoService interesadoService) {
        this.interesadoService = interesadoService;
    }

    @GetMapping
    public List<Interesado> obtenerInteresados() {
        return interesadoService.obtenerInteresados();

    }

    @PostMapping("/registrar")
    public ResponseEntity<Interesado> registrarInteresado(@RequestBody InteresadoDTO interesadoDTO) {
        Interesado nuevoInteresado = interesadoService.registrarInteresado(interesadoDTO);
        return new ResponseEntity<>(nuevoInteresado, HttpStatus.CREATED);


    }
}

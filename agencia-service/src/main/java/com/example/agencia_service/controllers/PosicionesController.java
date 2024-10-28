package com.example.agencia_service.controllers;


import com.example.agencia_service.service.PosicionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posiciones")
public class PosicionesController {

    private final PosicionesService posicionesService;
    @Autowired
    public PosicionesController(PosicionesService posicionesService) {
        this.posicionesService = posicionesService;
    }
}

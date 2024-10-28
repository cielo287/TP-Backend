package com.example.agencia_service.service;


import com.example.agencia_service.entities.Vehiculo;
import com.example.agencia_service.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehiculoService {

    private  final VehiculoRepository vehiculoRepository;
    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }


    public Vehiculo obtenerVehiculoPorId(long idVehiculo) {
        return vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new IllegalArgumentException("No existe el empleado con legajo: " + idVehiculo));
    }
}

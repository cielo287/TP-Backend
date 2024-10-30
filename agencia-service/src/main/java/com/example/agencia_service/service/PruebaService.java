package com.example.agencia_service.service;


import com.example.agencia_service.entities.Empleado;
import com.example.agencia_service.entities.Interesado;
import com.example.agencia_service.entities.Prueba;
import com.example.agencia_service.entities.Vehiculo;
import com.example.agencia_service.repositories.PruebaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PruebaService {

    private final PruebaRepository pruebaRepository;

    private final InteresadoService interesadoService;


    @Autowired
    public PruebaService(PruebaRepository pruebaRepository, InteresadoService interesadoService) {
        this.pruebaRepository = pruebaRepository;

        this.interesadoService = interesadoService;

    }

    public Prueba iniciarPrueba(Interesado interesado, Empleado empleado, Vehiculo vehiculo, LocalDateTime fechaHoraInicio, String comentario) {

        if (!interesadoService.existeInteresado(interesado.getId())) {
            throw new IllegalArgumentException("No existe el interesado");
        }
        if (tienePruebasEnCurso(vehiculo)) {
            throw new IllegalArgumentException("El vehiculo esta siendo utilizado en una prueba");
        }
        if (!interesadoService.esLicenciaValida(interesado.getFechaVencimientoLicencia())){
            throw new IllegalArgumentException("La licencia esta vencida");
        }
        Prueba nuevaPrueba = new Prueba();
        nuevaPrueba.setInteresado(interesado);
        nuevaPrueba.setEmpleado(empleado);
        nuevaPrueba.setVehiculo(vehiculo);
        nuevaPrueba.setFechaHoraInicio(fechaHoraInicio);
        nuevaPrueba.setComentarios(comentario);


        return pruebaRepository.save(nuevaPrueba);


        }

    public Prueba finalizarPrueba(LocalDateTime fechaHoraFin, int idPrueba, String comentario) {
        Optional<Prueba> optionalPrueba = pruebaRepository.findById((long) idPrueba);

        if (optionalPrueba.isPresent()) {
            Prueba prueba = optionalPrueba.get();

            prueba.setFechaHoraFin(fechaHoraFin);
            prueba.setComentarios(comentario);

            pruebaRepository.save(prueba);

            return prueba;
        } else {
            throw new EntityNotFoundException("Prueba con id " + idPrueba + " no encontrada.");
        }
    }









    public boolean tienePruebasEnCurso(Vehiculo vehiculo) {
        return vehiculo.getPruebas().stream().anyMatch(prueba -> prueba.getFechaHoraFin() == null);
    }

    public List<Prueba> listarPruebasEnCurso() {

        List<Prueba> pruebasEnCurso = pruebaRepository.findPruebasEnCurso();

        if (pruebasEnCurso.isEmpty()){
            return new ArrayList<>();
        }
        return pruebasEnCurso;
    }



    }



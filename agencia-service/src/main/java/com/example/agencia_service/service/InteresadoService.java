package com.example.agencia_service.service;


import com.example.agencia_service.DTO.InteresadoDTO;
import com.example.agencia_service.entities.Interesado;
import com.example.agencia_service.repositories.InteresadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InteresadoService {

    private final InteresadoRepository interesadoRepository;

    @Autowired
    public InteresadoService (InteresadoRepository interesadoRepository) {
        this.interesadoRepository = interesadoRepository;
    }

    public List<Interesado> obtenerInteresados(){
        return (List<Interesado>) interesadoRepository.findAll();
    }
    private Interesado interesadoDTOaEntity(InteresadoDTO dto) {
        Interesado interesado = new Interesado();
        interesado.setTipoDocumento(dto.getTipoDocumento());
        interesado.setDocumento(dto.getDocumento());
        interesado.setNombre(dto.getNombre());
        interesado.setApellido(dto.getApellido());
        interesado.setRestringido(dto.isRestringido());
        interesado.setNroLicencia(dto.getNroLicencia());
        interesado.setFechaVencimientoLicencia(dto.getFechaVencimientoLicencia());
        return interesado;
    }

    public InteresadoDTO convertirAObjetoDTO(Interesado interesado) {
        InteresadoDTO dto = new InteresadoDTO();
        dto.setTipoDocumento(interesado.getTipoDocumento());
        dto.setDocumento(interesado.getDocumento());
        dto.setNombre(interesado.getNombre());
        dto.setApellido(interesado.getApellido());
        dto.setRestringido(interesado.isRestringido());
        dto.setNroLicencia(interesado.getNroLicencia());
        dto.setFechaVencimientoLicencia(interesado.getFechaVencimientoLicencia());
        return dto;
    }


    public Interesado registrarInteresado(InteresadoDTO interesadoDTO) {
        Interesado nuevoInteresado = interesadoDTOaEntity(interesadoDTO);
        return interesadoRepository.save(nuevoInteresado);


    }

    public boolean existeInteresado(long id) {
        return interesadoRepository.existsById((long) id);

    }

    public boolean esLicenciaValida(LocalDate fechaVencimientoLicencia) {
        return (fechaVencimientoLicencia.isAfter(LocalDate.now()));

    }

    public Interesado obtenerInteresadoPorId (long idInteresado) {
        return interesadoRepository.findById(idInteresado)
                .orElseThrow(() -> new IllegalArgumentException("No existe el interesado con id: " + idInteresado));
    }






}

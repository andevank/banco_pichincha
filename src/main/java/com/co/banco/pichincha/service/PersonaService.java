package com.co.banco.pichincha.service;

import com.co.banco.pichincha.model.Persona;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    Persona crearPersona(Persona persona);

    Persona actualizarPersona(Persona persona);

    void eliminarPersona(Long id);

    Page<Persona> getPersonas(Integer page, Integer size, Boolean enablePagination);

    Optional<Persona> getPersonaId(Long id);

    boolean exitsById(Long id);
}

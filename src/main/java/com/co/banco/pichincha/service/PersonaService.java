package com.co.banco.pichincha.service;

import com.co.banco.pichincha.dto.PersonaDTO;
import com.co.banco.pichincha.model.Persona;

import java.util.List;

public interface PersonaService {

    List<PersonaDTO> getAllPersonas();

    PersonaDTO getPersonaById(Long id);

    PersonaDTO crearPersona(PersonaDTO entity);

    PersonaDTO actualizarPersona(PersonaDTO entity) throws Exception;

    void deleteById(Long id) throws Exception;

    Long count();
}

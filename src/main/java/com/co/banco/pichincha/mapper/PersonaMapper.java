package com.co.banco.pichincha.mapper;

import com.co.banco.pichincha.dto.PersonaDTO;
import com.co.banco.pichincha.model.Persona;

public class PersonaMapper {

    public static PersonaDTO maptoPersonaDTO(final Persona persona) {
        final PersonaDTO personaDTO = new PersonaDTO(
                persona.getId(),
                persona.getPersonaid(),
                persona.getNombres(),
                persona.getGenero(),
                persona.getEdad(),
                persona.getDireccion(),
                persona.getTelefono(),
                persona.isEstado());
        return personaDTO;
    }

    public static Persona maptoPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona(
                personaDTO.getId(),
                personaDTO.getPersonaid(),
                personaDTO.getNombres(),
                personaDTO.getGenero(),
                personaDTO.getEdad(),
                personaDTO.getDireccion(),
                personaDTO.getTelefono(),
                personaDTO.isEstado());
        return persona;
    }
}

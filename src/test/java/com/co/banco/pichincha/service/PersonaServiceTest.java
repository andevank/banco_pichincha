package com.co.banco.pichincha.service;

import com.co.banco.pichincha.dto.PersonaDTO;
import com.co.banco.pichincha.model.Persona;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class PersonaServiceTest {

    @Autowired
    PersonaService personaService;

    @Test
    void crearPersona(){

        PersonaDTO persona = new PersonaDTO();
        persona.setNombres("Margaret Tacher");
        persona.setGenero("Femenino");
        persona.setEdad(41L);
        persona.setDireccion("Avenida siempre viva 123");
        persona.setTelefono("5550123");
        persona.setEstado(true);

        personaService.crearPersona(persona);

        assertNotNull(persona, "Fallo al registrar persona");
    }
}

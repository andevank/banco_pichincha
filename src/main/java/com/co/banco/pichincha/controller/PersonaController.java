package com.co.banco.pichincha.controller;

import com.co.banco.pichincha.dto.PersonaDTO;
import com.co.banco.pichincha.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> findAll() {
        LOGGER.info("Getting personas...");
        List<PersonaDTO> listaPersonas = this.personaService.getAllPersonas();
        if (listaPersonas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        LOGGER.info("Getting personas finished");
        return new ResponseEntity<>(listaPersonas, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaDTO> findById(@PathVariable("id") Long id) {
        LOGGER.info("Getting persona by id...");
        PersonaDTO personaDTO = personaService.getPersonaById(id);
        LOGGER.info("Getting persona by id finished");
        return new ResponseEntity<>(personaDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonaDTO> save(@RequestBody PersonaDTO personaDTO) {
        LOGGER.info("saving persona...");
        PersonaDTO savePersonaDTO = this.personaService.crearPersona(personaDTO);
        LOGGER.info("persona save finished!");
        return new ResponseEntity<>(savePersonaDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PersonaDTO> update(@Valid @RequestBody PersonaDTO personaDTO) throws Exception {
        LOGGER.info("updating data persona....");
        PersonaDTO updatePersonaDTO = personaService.actualizarPersona(personaDTO);
        LOGGER.info("update persona finished!");
        return new ResponseEntity<>(updatePersonaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") final Long id) throws Exception {
        personaService.deleteById(id);
        LOGGER.info("delete persona finished!");
        return new ResponseEntity<>("Persona eliminada con exito!", HttpStatus.OK);
    }
}

package com.co.banco.pichincha.controller;

import com.co.banco.pichincha.model.Persona;
import com.co.banco.pichincha.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping
    public ResponseEntity<Page<Persona>> getAllPersonas(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "15") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination) {
        return ResponseEntity.ok(this.personaService.getPersonas(page, size, enablePagination));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Persona>> findPersonaById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.personaService.getPersonaId(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Persona> savePersona(@Valid @RequestBody final Persona persona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.personaService.crearPersona(persona));
    }

    @PutMapping
    public ResponseEntity<Persona> updatePersona(@Valid @RequestBody final Persona updPersona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.personaService.actualizarPersona(updPersona));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePersona(@PathVariable("id") Long id) {
        this.personaService.eliminarPersona(id);
        return ResponseEntity.ok(!this.personaService.exitsById(id));
    }


}

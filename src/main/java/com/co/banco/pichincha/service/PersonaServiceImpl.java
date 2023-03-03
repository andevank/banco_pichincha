package com.co.banco.pichincha.service;

import com.co.banco.pichincha.model.Persona;
import com.co.banco.pichincha.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona crearPersona(final Persona persona) {
        return this.personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(final Persona persona) {
        return this.personaRepository.saveAndFlush(persona);
    }

    @Override
    public void eliminarPersona(final Long id) {
        this.personaRepository.deleteById(id);
    }

    @Override
    public Page<Persona> getPersonas(final Integer page, final Integer size, final Boolean enablePagination) {
        return this.personaRepository.findAll(enablePagination? PageRequest.of(page,size): Pageable.unpaged());
    }

    @Override
    public Optional<Persona> getPersonaId(final Long id) {
        return Optional.of(this.personaRepository.findById(id).get());
    }

    @Override
    public boolean exitsById(final Long id){
        return this.personaRepository.existsById(id);
    }
}

package com.co.banco.pichincha.service;

import com.co.banco.pichincha.dto.PersonaDTO;
import com.co.banco.pichincha.exception.ResourceNotFoundException;
import com.co.banco.pichincha.mapper.PersonaMapper;
import com.co.banco.pichincha.model.Persona;
import com.co.banco.pichincha.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.print.attribute.standard.MediaSize;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PersonaDTO> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream().map(PersonaMapper::maptoPersonaDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaDTO getPersonaById(Long id) {
        Optional<Persona> result = personaRepository.findById(id);

        if(result.isEmpty()){
            throw new ResourceNotFoundException("Persona no encontrada con el id = "+id);
        }
        Persona persona = result.get();
        return PersonaMapper.maptoPersonaDTO(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return personaRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PersonaDTO crearPersona(PersonaDTO personaDTO) {

        if(personaDTO==null){
            throw new ResourceNotFoundException("La Persona es nula");
        }
        Persona persona= PersonaMapper.maptoPersona(personaDTO);
        Persona savePersona=personaRepository.save(persona);

        PersonaDTO savePersonaDTO=PersonaMapper.maptoPersonaDTO(savePersona);

       return savePersonaDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PersonaDTO actualizarPersona(PersonaDTO personaDTO){

        Persona currentPersona=personaRepository.findById(personaDTO.getId()).get();

        if(currentPersona==null){
            throw new ResourceNotFoundException("La Persona es nula");
        }
        if(currentPersona.getId()==null){
            throw new ResourceNotFoundException("La Persona no esta registrada");
        }
        currentPersona.setNombres(personaDTO.getNombres());
        currentPersona.setGenero(personaDTO.getGenero());
        currentPersona.setEdad(personaDTO.getEdad());
        currentPersona.setDireccion(personaDTO.getDireccion());
        currentPersona.setTelefono(personaDTO.getTelefono());
        currentPersona.setEstado(personaDTO.isEstado());
        Persona updatePersona=personaRepository.save(currentPersona);

        return PersonaMapper.maptoPersonaDTO(updatePersona);
    }
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Long id) throws Exception {
       personaRepository.deleteById(id);
    }


}

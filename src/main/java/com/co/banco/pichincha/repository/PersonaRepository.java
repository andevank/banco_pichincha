package com.co.banco.pichincha.repository;

import com.co.banco.pichincha.dto.PersonaDTO;
import com.co.banco.pichincha.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {

    PersonaDTO existsPersonaById(String personaid);
}

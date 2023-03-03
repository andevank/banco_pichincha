package com.co.banco.pichincha.repository;

import com.co.banco.pichincha.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}

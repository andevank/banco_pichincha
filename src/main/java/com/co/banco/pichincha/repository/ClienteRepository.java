package com.co.banco.pichincha.repository;

import com.co.banco.pichincha.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}

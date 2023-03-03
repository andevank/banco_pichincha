package com.co.banco.pichincha.repository;

import com.co.banco.pichincha.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}

package com.co.banco.pichincha.repository;

import com.co.banco.pichincha.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta,Long> {
}

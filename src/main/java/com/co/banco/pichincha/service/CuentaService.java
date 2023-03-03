package com.co.banco.pichincha.service;

import com.co.banco.pichincha.model.Cuenta;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CuentaService {
    Cuenta crearCuenta(Cuenta cuenta);

    Cuenta actualizarCuenta(Cuenta cuenta);

    void eliminarCuenta(Long id);

    Page<Cuenta> getCuentas(Integer page, Integer size, Boolean enablePagination);

    Optional<Cuenta> getCuentaId(Long id);

    boolean exitsById(Long id);
}

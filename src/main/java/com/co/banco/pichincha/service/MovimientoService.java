package com.co.banco.pichincha.service;

import com.co.banco.pichincha.model.Movimiento;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MovimientoService {
    Movimiento crearMovimiento(Movimiento movimiento);

    Movimiento actualizarMovimiento(Movimiento movimiento);

    void eliminarMovimiento(Long id);

    Page<Movimiento> getMovimientos(Integer page, Integer size, Boolean enablePagination);

    Optional<Movimiento> getMovimientoId(Long id);

    boolean exitsById(Long id);
}

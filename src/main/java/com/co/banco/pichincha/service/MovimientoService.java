package com.co.banco.pichincha.service;

import com.co.banco.pichincha.dto.MovimientoDTO;

import java.util.List;

public interface MovimientoService {

    List<MovimientoDTO> getAllMovimientos();

    MovimientoDTO getMovimientoById(Long id);

    MovimientoDTO crearMovimiento(MovimientoDTO entity);

    MovimientoDTO actualizarMovimiento(MovimientoDTO entity) throws Exception;

    MovimientoDTO getReporteFechaUsuario(Long id);

    void deleteById(Long id) throws Exception;

    Long count();
}

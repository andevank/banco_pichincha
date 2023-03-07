package com.co.banco.pichincha.mapper;

import com.co.banco.pichincha.dto.MovimientoDTO;
import com.co.banco.pichincha.model.Movimiento;

public class MovimientoMapper {

    public static MovimientoDTO maptoMovimientoDTO(final Movimiento movimiento) {
        final MovimientoDTO movimientoDTO = new MovimientoDTO(
                movimiento.getId(),
                movimiento.getMovimiento(),
                movimiento.getEstado(),
                movimiento.getFecha(),
                movimiento.getCuenta());
        return movimientoDTO;
    }

    public static Movimiento maptoMovimiento(MovimientoDTO movimientoDTO) {
        Movimiento movimiento = new Movimiento(
                movimientoDTO.getId(),
                movimientoDTO.getMovimiento(),
                movimientoDTO.getEstado(),
                movimientoDTO.getFecha(),
                movimientoDTO.getCuenta());
        return movimiento;
    }
}

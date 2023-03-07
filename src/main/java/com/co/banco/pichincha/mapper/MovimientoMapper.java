package com.co.banco.pichincha.mapper;

import com.co.banco.pichincha.dto.MovimientoDTO;
import com.co.banco.pichincha.model.Movimiento;

public class MovimientoMapper {

    public static MovimientoDTO maptoMovimientoDTO(final Movimiento movimiento) {
        final MovimientoDTO movimientoDTO = new MovimientoDTO(
                movimiento.getId(),
                movimiento.getFecha(),
                movimiento.getTipoMovimiento(),
                movimiento.getValor(),
                movimiento.getSaldo(),
                movimiento.getCuenta());
        return movimientoDTO;
    }

    public static Movimiento maptoMovimiento(MovimientoDTO movimientoDTO) {
        Movimiento movimiento = new Movimiento(
                movimientoDTO.getId(),
                movimientoDTO.getFecha(),
                movimientoDTO.getTipoMovimiento(),
                movimientoDTO.getValor(),
                movimientoDTO.getSaldo(),
                movimientoDTO.getCuenta());
        return movimiento;
    }
}

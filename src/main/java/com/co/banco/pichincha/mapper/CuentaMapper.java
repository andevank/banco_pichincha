package com.co.banco.pichincha.mapper;

import com.co.banco.pichincha.dto.CuentaDTO;
import com.co.banco.pichincha.model.Cuenta;

public class CuentaMapper {

    public static CuentaDTO maptoCuentaDTO(final Cuenta cuenta) {
        final CuentaDTO cuentaDTO = new CuentaDTO(
                cuenta.getId(),
                cuenta.getNumerocuenta(),
                cuenta.getTipocuenta(),
                cuenta.getSaldoinicial(),
                cuenta.getEstado(),
                cuenta.getCliente());
        return cuentaDTO;
    }

    public static Cuenta maptoCuenta(CuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta(
                cuentaDTO.getId(),
                cuentaDTO.getNumerocuenta(),
                cuentaDTO.getTipocuenta(),
                cuentaDTO.getSaldoinicial(),
                cuentaDTO.getEstado(),
                cuentaDTO.getCliente());
        return cuenta;
    }
}

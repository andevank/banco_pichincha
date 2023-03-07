package com.co.banco.pichincha.service;

import com.co.banco.pichincha.dto.CuentaDTO;

import java.util.List;

public interface CuentaService {

    List<CuentaDTO> getAllCuentas();

    CuentaDTO getCuentaById(Long id);

    CuentaDTO crearCuenta(CuentaDTO entity);

    CuentaDTO actualizarCuenta(CuentaDTO entity) throws Exception;

    void deleteById(Long id) throws Exception;

    Long count();
}

package com.co.banco.pichincha.service;

import com.co.banco.pichincha.model.Cuenta;
import com.co.banco.pichincha.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Cuenta crearCuenta(final Cuenta cuenta) {
        return this.cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta actualizarCuenta(final Cuenta cuenta) {
        return this.cuentaRepository.saveAndFlush(cuenta);
    }

    @Override
    public void eliminarCuenta(final Long id) {
        this.cuentaRepository.deleteById(id);
    }

    @Override
    public Page<Cuenta> getCuentas(final Integer page, final Integer size, final Boolean enablePagination) {
        return this.cuentaRepository.findAll(enablePagination ? PageRequest.of(page, size) : Pageable.unpaged());
    }

    @Override
    public Optional<Cuenta> getCuentaId(final Long id) {
        return Optional.of(this.cuentaRepository.findById(id).get());
    }

    @Override
    public boolean exitsById(final Long id) {
        return this.cuentaRepository.existsById(id);
    }
}

package com.co.banco.pichincha.service;

import com.co.banco.pichincha.model.Movimiento;
import com.co.banco.pichincha.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService{

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public Movimiento crearMovimiento(final Movimiento movimiento) {
        return this.movimientoRepository.save(movimiento);
    }

    @Override
    public Movimiento actualizarMovimiento(final Movimiento movimiento) {
        return this.movimientoRepository.saveAndFlush(movimiento);
    }

    @Override
    public void eliminarMovimiento(final Long id) {
        this.movimientoRepository.deleteById(id);
    }

    @Override
    public Page<Movimiento> getMovimientos(final Integer page, final Integer size, final Boolean enablePagination) {
        return this.movimientoRepository.findAll(enablePagination? PageRequest.of(page,size): Pageable.unpaged());
    }

    @Override
    public Optional<Movimiento> getMovimientoId(final Long id) {
        return Optional.of(this.movimientoRepository.findById(id).get());
    }

    @Override
    public boolean exitsById(final Long id){
        return this.movimientoRepository.existsById(id);
    }
}

package com.co.banco.pichincha.service;

import com.co.banco.pichincha.dto.MovimientoDTO;
import com.co.banco.pichincha.exception.ResourceNotFoundException;
import com.co.banco.pichincha.mapper.MovimientoMapper;
import com.co.banco.pichincha.model.Movimiento;
import com.co.banco.pichincha.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDTO> getAllMovimientos() {
        List<Movimiento> movimientos = movimientoRepository.findAll();
        return movimientos.stream().map(MovimientoMapper::maptoMovimientoDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MovimientoDTO getMovimientoById(Long id) {
        Optional<Movimiento> result = movimientoRepository.findById(id);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Movimiento no encontrado con el id = " + id);
        }
        Movimiento movimiento = result.get();
        return MovimientoMapper.maptoMovimientoDTO(movimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public MovimientoDTO getReporteFechaUsuario(Long clienteid) {
        Optional<Movimiento> result = movimientoRepository.getReporteFechaUsuario(clienteid);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Movimiento no encontrado con el id = " + clienteid);
        }
        Movimiento movimiento = result.get();
        return MovimientoMapper.maptoMovimientoDTO(movimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return movimientoRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MovimientoDTO crearMovimiento(MovimientoDTO movimientoDTO) {

        if (movimientoDTO == null) {
            throw new ResourceNotFoundException("El Movimiento es nulo");
        }
        Movimiento movimiento = MovimientoMapper.maptoMovimiento(movimientoDTO);
        Movimiento saveMovimiento = movimientoRepository.save(movimiento);

        MovimientoDTO saveMovimientoDTO = MovimientoMapper.maptoMovimientoDTO(saveMovimiento);

        return saveMovimientoDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MovimientoDTO actualizarMovimiento(MovimientoDTO movimientoDTO) {

        Movimiento currentMovimiento = movimientoRepository.findById(movimientoDTO.getId()).get();

        if (currentMovimiento == null) {
            throw new ResourceNotFoundException("La Movimiento es nula");
        }
        if (currentMovimiento.getId() == null) {
            throw new ResourceNotFoundException("La Movimiento no esta registrada");
        }

        currentMovimiento.setId(movimientoDTO.getId());
        currentMovimiento.setFecha(movimientoDTO.getFecha());
        currentMovimiento.setTipoMovimiento(movimientoDTO.getTipoMovimiento());
        currentMovimiento.setValor(movimientoDTO.getValor());
        currentMovimiento.setSaldo(movimientoDTO.getSaldo());
        currentMovimiento.setCuenta(movimientoDTO.getCuenta());


        Movimiento updateMovimiento = movimientoRepository.save(currentMovimiento);

        return MovimientoMapper.maptoMovimientoDTO(updateMovimiento);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Long id) throws Exception {
        movimientoRepository.deleteById(id);
    }
}
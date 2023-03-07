package com.co.banco.pichincha.service;

import com.co.banco.pichincha.dto.CuentaDTO;
import com.co.banco.pichincha.exception.ResourceNotFoundException;
import com.co.banco.pichincha.mapper.CuentaMapper;
import com.co.banco.pichincha.model.Cuenta;
import com.co.banco.pichincha.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CuentaDTO> getAllCuentas() {
        List<Cuenta> Cuentas = cuentaRepository.findAll();
        return Cuentas.stream().map(CuentaMapper::maptoCuentaDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CuentaDTO getCuentaById(Long id) {
        Optional<Cuenta> result = cuentaRepository.findById(id);

        if(result.isEmpty()){
            throw new ResourceNotFoundException("Cuenta no encontrada con el id = "+id);
        }
        Cuenta Cuenta = result.get();
        return CuentaMapper.maptoCuentaDTO(Cuenta);
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return cuentaRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public CuentaDTO crearCuenta(CuentaDTO cuentaDTO) {

        if(cuentaDTO==null){
            throw new ResourceNotFoundException("La Cuenta es nula");
        }
        Cuenta cuenta= CuentaMapper.maptoCuenta(cuentaDTO);
        Cuenta saveCuenta=cuentaRepository.save(cuenta);

        CuentaDTO saveCuentaDTO=CuentaMapper.maptoCuentaDTO(saveCuenta);

        return saveCuentaDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public CuentaDTO actualizarCuenta(CuentaDTO cuentaDTO){

        Cuenta currentCuenta=cuentaRepository.findById(cuentaDTO.getId()).get();

        if(currentCuenta==null){
            throw new ResourceNotFoundException("La Cuenta es nula");
        }
        if(currentCuenta.getId()==null){
            throw new ResourceNotFoundException("La Cuenta no esta registrada");
        }

        currentCuenta.setId(cuentaDTO.getId());
        currentCuenta.setNumerocuenta(cuentaDTO.getNumerocuenta());
        currentCuenta.setTipocuenta(cuentaDTO.getTipocuenta());
        currentCuenta.setSaldoinicial(cuentaDTO.getSaldoinicial());
        currentCuenta.setEstado(cuentaDTO.getEstado());
        currentCuenta.setCliente(cuentaDTO.getCliente());

        Cuenta updateCuenta=cuentaRepository.save(currentCuenta);

        return CuentaMapper.maptoCuentaDTO(updateCuenta);
    }
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Long id) throws Exception {
        cuentaRepository.deleteById(id);
    }
}

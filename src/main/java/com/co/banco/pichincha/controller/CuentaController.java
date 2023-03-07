package com.co.banco.pichincha.controller;

import com.co.banco.pichincha.dto.CuentaDTO;
import com.co.banco.pichincha.service.CuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {


    private static final Logger LOGGER = LoggerFactory.getLogger(CuentaController.class);

    @Autowired
    CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<CuentaDTO>> findAll() {
        LOGGER.info("Getting Cuentas...");
        List<CuentaDTO> listaCuentas = this.cuentaService.getAllCuentas();
        if (listaCuentas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        LOGGER.info("Getting Cuentas finished");
        return new ResponseEntity<>(listaCuentas, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CuentaDTO> findById(@PathVariable("id") Long id) {
        LOGGER.info("Getting Cuenta by id...");
        CuentaDTO cuentaDTO = cuentaService.getCuentaById(id);
        LOGGER.info("Getting Cuenta by id finished");
        return new ResponseEntity<>(cuentaDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CuentaDTO> save(@RequestBody CuentaDTO cuentaDTO) {
        LOGGER.info("saving Cuenta...");
        CuentaDTO saveCuentaDTO = this.cuentaService.crearCuenta(cuentaDTO);
        LOGGER.info("Cuenta save finished!");
        return new ResponseEntity<>(saveCuentaDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CuentaDTO> update(@Valid @RequestBody CuentaDTO cuentaDTO) throws Exception {
        LOGGER.info("updating data Cuenta....");
        CuentaDTO updateCuentaDTO = cuentaService.actualizarCuenta(cuentaDTO);
        LOGGER.info("update Cuenta finished!");
        return new ResponseEntity<>(updateCuentaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") final Long id) throws Exception {
        cuentaService.deleteById(id);
        LOGGER.info("delete Cuenta finished!");
        return new ResponseEntity<>("Cuenta eliminada con exito!", HttpStatus.OK);
    }
}

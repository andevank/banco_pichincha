package com.co.banco.pichincha.controller;

import com.co.banco.pichincha.dto.MovimientoDTO;
import com.co.banco.pichincha.service.MovimientoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movimientos")
public class MovimientoController {


    private static final Logger LOGGER = LoggerFactory.getLogger(MovimientoController.class);

    @Autowired
    MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<List<MovimientoDTO>> findAll() {
        LOGGER.info("Getting Movimientos...");
        List<MovimientoDTO> listaMovimientos = this.movimientoService.getAllMovimientos();
        if (listaMovimientos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        LOGGER.info("Getting Movimientos finished");
        return new ResponseEntity<>(listaMovimientos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimientoDTO> findById(@PathVariable("id") Long id) {
        LOGGER.info("Getting Movimiento by id...");
        MovimientoDTO movimientoDTO = movimientoService.getMovimientoById(id);
        LOGGER.info("Getting Movimiento by id finished");
        return new ResponseEntity<>(movimientoDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/reporte/{clienteid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimientoDTO> getReporteFechaUsuario(@PathVariable(name="clienteid") @NotNull final Long clienteid) {
        LOGGER.info("Getting Movimiento by id...");
        MovimientoDTO movimientoDTO = movimientoService.getReporteFechaUsuario(clienteid);
        LOGGER.info("Getting Movimiento by id finished");
        return new ResponseEntity<>(movimientoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovimientoDTO> save(@RequestBody MovimientoDTO movimientoDTO) {
        LOGGER.info("saving Movimiento...");
        MovimientoDTO saveMovimientoDTO = this.movimientoService.crearMovimiento(movimientoDTO);
        LOGGER.info("Movimiento save finished!");
        return new ResponseEntity<>(saveMovimientoDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MovimientoDTO> update(@Valid @RequestBody MovimientoDTO movimientoDTO) throws Exception {
        LOGGER.info("updating data Movimiento....");
        MovimientoDTO updateMovimientoDTO = movimientoService.actualizarMovimiento(movimientoDTO);
        LOGGER.info("update Movimiento finished!");
        return new ResponseEntity<>(updateMovimientoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") final Long id) throws Exception {
        movimientoService.deleteById(id);
        LOGGER.info("delete Movimiento finished!");
        return new ResponseEntity<>("Movimiento eliminado con exito!", HttpStatus.OK);
    }
}

package com.co.banco.pichincha.controller;

import com.co.banco.pichincha.model.Movimiento;
import com.co.banco.pichincha.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Movimiento")
public class MovimientoController {

    @Autowired
    MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<Page<Movimiento>> getAllMovimientos(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "15") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination) {
        return ResponseEntity.ok(this.movimientoService.getMovimientos(page,size,enablePagination));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movimiento>>findMovimientoById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.movimientoService.getMovimientoId(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Movimiento> saveMovimiento(@Valid @RequestBody Movimiento movimiento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movimientoService.crearMovimiento(movimiento));
    }

    @PutMapping
    public ResponseEntity<Movimiento> updateMovimiento(@Valid @RequestBody Movimiento updMovimiento){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movimientoService.actualizarMovimiento(updMovimiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovimiento(@PathVariable("id") Long id){
        this.movimientoService.eliminarMovimiento(id);
        return ResponseEntity.ok(!this.movimientoService.exitsById(id));
    }




}

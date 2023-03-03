package com.co.banco.pichincha.controller;

import com.co.banco.pichincha.model.Cuenta;
import com.co.banco.pichincha.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Cuentas")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<Page<Cuenta>> getAllCuentas(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "15") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination) {
        return ResponseEntity.ok(this.cuentaService.getCuentas(page, size, enablePagination));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cuenta>> findCuentaById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cuentaService.getCuentaId(id));
    }

    @PostMapping
    public ResponseEntity<Cuenta> saveCuenta(@Valid @RequestBody Cuenta cuenta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.cuentaService.crearCuenta(cuenta));
    }

    @PutMapping
    public ResponseEntity<Cuenta> updateCuenta(@Valid @RequestBody Cuenta updCuenta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.cuentaService.actualizarCuenta(updCuenta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCuenta(@PathVariable("id") Long id) {
        this.cuentaService.eliminarCuenta(id);
        return ResponseEntity.ok(!this.cuentaService.exitsById(id));
    }

}

package com.co.banco.pichincha.controller;

import com.co.banco.pichincha.model.Cliente;
import com.co.banco.pichincha.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<Cliente>> getAllClientes(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "15") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination) {
        return ResponseEntity.ok(this.clienteService.getClientes(page, size, enablePagination));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findClienteById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.getClienteId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteService.crearCliente(cliente));
    }

    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@Valid @RequestBody Cliente updCliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteService.actualizarCliente(updCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCliente(@PathVariable("id") Long id) {
        this.clienteService.eliminarCliente(id);
        return ResponseEntity.ok(!this.clienteService.exitsById(id));
    }

}

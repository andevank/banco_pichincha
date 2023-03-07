package com.co.banco.pichincha.controller;

import com.co.banco.pichincha.dto.ClienteDTO;

import com.co.banco.pichincha.service.ClienteService;
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
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

   @Autowired
   ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        LOGGER.info("Getting Clientes...");
        List<ClienteDTO> listaClientes = this.clienteService.getAllClientes();
        if (listaClientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        LOGGER.info("Getting Clientes finished");
        return new ResponseEntity<>(listaClientes, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> findById(@PathVariable("id") Long id) {
        LOGGER.info("Getting Cliente by id...");
        ClienteDTO clienteDTO = clienteService.getClienteById(id);
        LOGGER.info("Getting Cliente by id finished");
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO) {
        LOGGER.info("saving Cliente...");
        ClienteDTO saveClienteDTO = this.clienteService.crearCliente(clienteDTO);
        LOGGER.info("Cliente save finished!");
        return new ResponseEntity<>(saveClienteDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> update(@Valid @RequestBody ClienteDTO clienteDTO) throws Exception {
        LOGGER.info("updating data Cliente....");
        ClienteDTO updateClienteDTO = clienteService.actualizarCliente(clienteDTO);
        LOGGER.info("update Cliente finished!");
        return new ResponseEntity<>(updateClienteDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") final Long id) throws Exception {
        clienteService.deleteById(id);
        LOGGER.info("delete Cliente finished!");
        return new ResponseEntity<>("Cliente eliminado con exito!", HttpStatus.OK);
    }
}

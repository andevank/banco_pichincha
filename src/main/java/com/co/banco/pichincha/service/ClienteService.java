package com.co.banco.pichincha.service;

import com.co.banco.pichincha.model.Cliente;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ClienteService {
    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Cliente cliente);

    void eliminarCliente(Long id);

    Page<Cliente> getClientes(Integer page, Integer size, Boolean enablePagination);

    Optional<Cliente> getClienteId(Long id);

    boolean exitsById(Long id);
}

package com.co.banco.pichincha.mapper;

import com.co.banco.pichincha.dto.ClienteDTO;
import com.co.banco.pichincha.model.Cliente;

public class ClienteMapper {

    public static ClienteDTO maptoClienteDTO(final Cliente cliente) {
        final ClienteDTO clienteDTO = new ClienteDTO(
                cliente.getClienteid(),
                cliente.getContrasena(),
                cliente.getEstado(),
                cliente.getPersona());
        return clienteDTO;
    }

    public static Cliente maptoCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(
                clienteDTO.getClienteid(),
                clienteDTO.getContrasena(),
                clienteDTO.getEstado(),
                clienteDTO.getPersona());
        return cliente;
    }
}

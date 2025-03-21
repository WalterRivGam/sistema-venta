package edu.cibertec.service;

import java.util.List;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.entity.ClienteEntity;

public interface ClienteService {

    List<ClienteDTO> listarClientes();

    ClienteDTO obtenerClientes(Integer idCliente);

    ClienteDTO buscarClientePorDNI(String dni);

    ClienteDTO registrarCliente(ClienteDTO clienteDTO);

    ClienteDTO actualizarCliente(ClienteDTO clienteDTO);
    
    ClienteDTO eliminarCliente(Integer idCliente);
    
}

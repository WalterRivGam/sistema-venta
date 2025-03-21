package edu.cibertec.service;

import java.util.List;
import edu.cibertec.dto.ClienteDTO;

public interface ClienteService {
    List<ClienteDTO> listarClientes();
    ClienteDTO obtenerCliente(Integer idCliente);
    ClienteDTO registrarCliente(ClienteDTO cliente);
    void actualizarCliente(ClienteDTO cliente);
    void eliminarCliente(Integer idCliente);
}

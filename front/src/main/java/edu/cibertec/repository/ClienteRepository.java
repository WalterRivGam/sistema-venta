package edu.cibertec.repository;

import java.util.List;
import edu.cibertec.dto.ClienteDTO;

public interface ClienteRepository {
    public List<ClienteDTO> listarClientes();
    public ClienteDTO obtenerCliente(Integer idCliente);
    public ClienteDTO registrarCliente(ClienteDTO cliente);
    public void actualizarCliente(ClienteDTO cliente);
    public void eliminarCliente(Integer idCliente);
}

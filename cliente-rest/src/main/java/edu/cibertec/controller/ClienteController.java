package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/clientes")
@Tag(name = "Clientes", description = "Api de Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Listar clientes", description = "Listado de clientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{idCliente}")
    @Operation(summary = "Obtener clientes", description = "Obtener clientes por Id")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable Integer idCliente) {
        return ResponseEntity.ok(clienteService.obtenerClientes(idCliente));
    }

    @GetMapping("/dni/{dni}")
    @Operation(summary = "Buscar cliente por DNI", description = "Obtiene un cliente mediante su DNI")
    public ResponseEntity<ClienteDTO> buscarClientePorDni(@PathVariable String dni) {
        return ResponseEntity.ok(clienteService.buscarClientePorDNI(dni));
    }

    @PostMapping
    @Operation(summary = "Registrar cliente", description = "Registra a los clientes")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO nuevoCliente = clienteService.registrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @PutMapping
    @Operation(summary = "Actualizar un cliente", description = "Modifica los datos de un cliente existente")
    public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteActualizado = clienteService.actualizarCliente(clienteDTO);
        return (clienteActualizado != null)? ResponseEntity.ok(clienteActualizado) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{idCliente}")
    @Operation(summary = "Eliminar un cliente", description = "Elimina un cliente de la base de datos por su ID")
    public ResponseEntity<ClienteDTO> eliminarCliente(@PathVariable Integer idCliente) {
        ClienteDTO clienteEliminado = clienteService.eliminarCliente(idCliente);
        return (clienteEliminado != null)? ResponseEntity.ok(clienteEliminado) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}

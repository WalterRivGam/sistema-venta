package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.service.ClienteService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sistemaventa")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public ModelAndView cliente() {
        ModelAndView modelAndView = new ModelAndView("cliente");
        modelAndView.addObject("listaClientes", clienteService.listarClientes());
        return modelAndView;
    }

    @GetMapping("/cliente/nuevo")
    public ModelAndView nuevoCliente() {
        ModelAndView modelAndView = new ModelAndView("formularioCliente");
        modelAndView.addObject("cliente", new ClienteDTO());
        return modelAndView;
    }

    @PostMapping("/cliente/guardar")
    public ModelAndView guardarCliente(@ModelAttribute ClienteDTO cliente) {
        clienteService.registrarCliente(cliente);
        return new ModelAndView("redirect:/sistemaventa/cliente");
    }

    @GetMapping("/cliente/editar/{id}")
    public ModelAndView editarCliente(@PathVariable("id") Integer idCliente) {
        ClienteDTO cliente = clienteService.obtenerCliente(idCliente);
        if (cliente != null) {
            ModelAndView modelAndView = new ModelAndView("formularioCliente");
            modelAndView.addObject("cliente", cliente);
            return modelAndView;
        }
        return new ModelAndView("redirect:/sistemaventa/cliente");
    }

    @PostMapping("/cliente/actualizar")
    public ModelAndView actualizarCliente(@ModelAttribute ClienteDTO cliente) {
        clienteService.actualizarCliente(cliente);
        return new ModelAndView("redirect:/sistemaventa/cliente");
    }

    @GetMapping("/cliente/eliminar/{id}")
    public ModelAndView eliminarCliente(@PathVariable("id") Integer idCliente) {
        clienteService.eliminarCliente(idCliente);
        return new ModelAndView("redirect:/sistemaventa/cliente");
    }
}

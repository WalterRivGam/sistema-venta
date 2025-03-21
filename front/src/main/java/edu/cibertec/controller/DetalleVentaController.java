package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.dto.DetalleVentaDTO;
import edu.cibertec.service.DetalleVentaService;

@Controller
@RequestMapping("/sistemaventa")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping("/detalleventa")
    public ModelAndView detalleVenta() {
        ModelAndView modelAndView = new ModelAndView("detalleVenta");
        modelAndView.addObject("listaDetallesVenta", detalleVentaService.listarDetallesVenta());
        return modelAndView;
    }

    @GetMapping("/detalleventa/nuevo")
    public ModelAndView nuevoDetalleVenta() {
        ModelAndView modelAndView = new ModelAndView("formularioDetalleVenta");
        modelAndView.addObject("detalleVenta", new DetalleVentaDTO());
        return modelAndView;
    }

    @PostMapping("/detalleventa/guardar")
    public ModelAndView guardarDetalleVenta(@ModelAttribute DetalleVentaDTO detalleVenta) {
        detalleVentaService.registrarDetalleVenta(detalleVenta);
        return new ModelAndView("redirect:/sistemaventa/detalleventa");
    }

    @GetMapping("/detalleventa/editar/{id}")
    public ModelAndView editarDetalleVenta(@PathVariable("id") Integer idDetalleVenta) {
        DetalleVentaDTO detalleVenta = detalleVentaService.obtenerDetalleVenta(idDetalleVenta);
        if (detalleVenta != null) {
            ModelAndView modelAndView = new ModelAndView("formularioDetalleVenta");
            modelAndView.addObject("detalleVenta", detalleVenta);
            return modelAndView;
        }
        return new ModelAndView("redirect:/sistemaventa/detalleventa");
    }

    @PostMapping("/detalleventa/actualizar")
    public ModelAndView actualizarDetalleVenta(@ModelAttribute DetalleVentaDTO detalleVenta) {
        detalleVentaService.actualizarDetalleVenta(detalleVenta);
        return new ModelAndView("redirect:/sistemaventa/detalleventa");
    }

    @GetMapping("/detalleventa/eliminar/{id}")
    public ModelAndView eliminarDetalleVenta(@PathVariable("id") Integer idDetalleVenta) {
        detalleVentaService.eliminarDetalleVenta(idDetalleVenta);
        return new ModelAndView("redirect:/sistemaventa/detalleventa");
    }
}

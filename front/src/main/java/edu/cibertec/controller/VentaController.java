package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.cibertec.dto.VentaDTO;
import edu.cibertec.service.VentaService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sistemaventa")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping("/venta")
    public ModelAndView venta() {
        ModelAndView modelAndView = new ModelAndView("venta");
        modelAndView.addObject("listaVentas", ventaService.listarVentas());
        return modelAndView;
    }

    @GetMapping("/venta/nuevo")
    public ModelAndView nuevaVenta() {
        ModelAndView modelAndView = new ModelAndView("formularioVenta");
        modelAndView.addObject("venta", new VentaDTO());
        return modelAndView;
    }

    @PostMapping("/venta/guardar")
    public ModelAndView guardarVenta(@ModelAttribute VentaDTO venta) {
        ventaService.registrarVenta(venta);
        return new ModelAndView("redirect:/sistemaventa/venta");
    }

    @GetMapping("/venta/editar/{id}")
    public ModelAndView editarVenta(@PathVariable("id") Integer idVenta) {
        VentaDTO venta = ventaService.obtenerVenta(idVenta);
        if (venta != null) {
            ModelAndView modelAndView = new ModelAndView("formularioVenta");
            modelAndView.addObject("venta", venta);
            return modelAndView;
        }
        return new ModelAndView("redirect:/sistemaventa/venta");
    }

    @PostMapping("/venta/actualizar")
    public ModelAndView actualizarVenta(@ModelAttribute VentaDTO venta) {
        ventaService.actualizarVenta(venta);
        return new ModelAndView("redirect:/sistemaventa/venta");
    }

    @GetMapping("/venta/eliminar/{id}")
    public ModelAndView eliminarVenta(@PathVariable("id") Integer idVenta) {
        ventaService.eliminarVenta(idVenta);
        return new ModelAndView("redirect:/sistemaventa/venta");
    }
}

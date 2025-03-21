package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.service.ProductoService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sistemaventa")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/producto")
    public ModelAndView producto() {
        ModelAndView modelAndView = new ModelAndView("producto");
        modelAndView.addObject("listaProductos", productoService.listarProductos());
        return modelAndView;
    }

    @GetMapping("/producto/nuevo")
    public ModelAndView nuevoProducto() {
        ModelAndView modelAndView = new ModelAndView("formularioProducto");
        modelAndView.addObject("producto", new ProductoDTO());
        return modelAndView;
    }

    @PostMapping("/producto/guardar")
    public ModelAndView guardarProducto(@ModelAttribute ProductoDTO producto) {
        productoService.registrarProducto(producto);
        return new ModelAndView("redirect:/sistemaventa/producto");
    }

    @GetMapping("/producto/editar/{id}")
    public ModelAndView editarProducto(@PathVariable("id") Integer idProducto) {
        ProductoDTO producto = productoService.obtenerProducto(idProducto);
        if (producto != null) {
            ModelAndView modelAndView = new ModelAndView("formularioProducto");
            modelAndView.addObject("producto", producto);
            return modelAndView;
        }
        return new ModelAndView("redirect:/sistemaventa/producto");
    }

    @PostMapping("/producto/actualizar")
    public ModelAndView actualizarProducto(@ModelAttribute ProductoDTO producto) {
        productoService.actualizarProducto(producto);
        return new ModelAndView("redirect:/sistemaventa/producto");
    }

    @GetMapping("/producto/eliminar/{id}")
    public ModelAndView eliminarProducto(@PathVariable("id") Integer idProducto) {
        productoService.eliminarProducto(idProducto);
        return new ModelAndView("redirect:/sistemaventa/producto");
    }
}

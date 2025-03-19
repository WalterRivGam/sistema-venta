package edu.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sistemaventa")
public class VentaController {
  @GetMapping("/venta")
  public String venta() {
    return "venta";
  }
}

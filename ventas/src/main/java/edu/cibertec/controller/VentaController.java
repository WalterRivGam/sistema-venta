package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.VentaEntity;
import edu.cibertec.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("api/v1/ventas")
@Tag(name = "Venta", description = "API de Ventas")
public class VentaController {
  @Autowired
  private VentaService ventaService;

  @GetMapping
  @Operation(summary = "Listar ventas", description = "Listar Ventas")
  public ResponseEntity<List<VentaEntity>> listarVentas() {
    try {
      List<VentaEntity> listaVentas = ventaService.listarVentas();
      listaVentas.forEach(venta -> 
        venta.add(linkTo(methodOn(VentaController.class).obtenerVenta(venta.getId()))
        .withRel("Ver venta " + venta.getId()))
      );
      return ResponseEntity.ok(listaVentas);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/{idVenta}")
  @Operation(summary = "Buscar Venta por ID", description = "Buscar Venta por ID")
  public ResponseEntity<VentaEntity> obtenerVenta(@PathVariable Integer idVenta) {
    try {
      VentaEntity Venta = ventaService.obtenerVenta(idVenta);
      if (Venta == null) {
        return ResponseEntity.notFound().build();
      } else {
        return new ResponseEntity(ventaService.obtenerVenta(idVenta), HttpStatus.OK);
      }
    } catch (Exception ex) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @PostMapping
  @Operation(summary = "Registrar Venta", description = "Registrar Venta")
  public ResponseEntity<VentaEntity> registrarVenta(@RequestBody VentaEntity venta) {
    try {
      return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.registrarVenta(venta));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } 
  }

  @PutMapping("/{idVenta}")
  @Operation(summary = "Actualizar Venta", description = "Actualizar Venta")
  public ResponseEntity<VentaEntity> actualizarVenta(@PathVariable Integer idVenta, @RequestBody VentaEntity venta) {
    try {
      venta.setId(idVenta);
      return ResponseEntity.ok(ventaService.actualizarVenta(venta));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
  
  @DeleteMapping("/{idVenta}")
  @Operation(summary = "Eliminar Venta", description = "Eliminar Venta")
  public ResponseEntity<String> eliminarVenta(@PathVariable Integer idVenta) {
    try {
      VentaEntity venta = ventaService.obtenerVenta(idVenta);
      if (venta != null) {
        return ResponseEntity.noContent().build();
      } else {
        return ResponseEntity.notFound().build();
      }
    } catch (Exception ex) {
      return ResponseEntity.internalServerError().build();
    }
  }
  
}

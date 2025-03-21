package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.DetalleVentaEntity;
import edu.cibertec.service.DetalleVentaService;
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
@RequestMapping("api/v1/detalles-venta")
@Tag(name = "DetalleVenta", description = "API de Detalles de Venta")
public class DetalleVentaController {
  @Autowired
  private DetalleVentaService detalleVentaService;

  @GetMapping
  @Operation(summary = "Listar detalles de venta", description = "Listar Detalles de Venta")
  public ResponseEntity<List<DetalleVentaEntity>> listarDetallesVenta() {
    try {
      List<DetalleVentaEntity> listaDetallesVenta = detalleVentaService.listarDetallesVenta();
      listaDetallesVenta.forEach(detalle -> 
        detalle.add(linkTo(methodOn(DetalleVentaController.class).obtenerDetalleVenta(detalle.getId()))
        .withRel("Ver detalle de venta " + detalle.getId()))
      );
      return ResponseEntity.ok(listaDetallesVenta);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/{idVenta}")
  @Operation(summary = "Listar detalles de venta de una venta", description = "Listar Detalles de Venta de una venta")
  public ResponseEntity<List<DetalleVentaEntity>> listarDetallesVenta(@PathVariable Integer idVenta) {
    try {
      List<DetalleVentaEntity> listaDetallesVenta = detalleVentaService.listarDetallesVenta(idVenta);
      listaDetallesVenta.forEach(detalle -> 
        detalle.add(linkTo(methodOn(DetalleVentaController.class).obtenerDetalleVenta(detalle.getId()))
        .withRel("Ver detalle de venta " + detalle.getId()))
      );
      return ResponseEntity.ok(listaDetallesVenta);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/{idDetalleVenta}")
  @Operation(summary = "Buscar Detalle de Venta por ID", description = "Buscar Detalle de Venta por ID")
  public ResponseEntity<DetalleVentaEntity> obtenerDetalleVenta(@PathVariable Integer idDetalleVenta) {
    try {
      DetalleVentaEntity detalleVenta = detalleVentaService.obtenerDetalleVenta(idDetalleVenta);
      if (detalleVenta == null) {
        return ResponseEntity.notFound().build();
      } else {
        return ResponseEntity.ok(detalleVenta);
      }
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
  
  @PostMapping
  @Operation(summary = "Registrar Detalle de Venta", description = "Registrar Detalle de Venta")
  public ResponseEntity<DetalleVentaEntity> registrarDetalleVenta(@RequestBody DetalleVentaEntity detalleVenta) {
    try {
      return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.registrarDetalleVenta(detalleVenta));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } 
  }

  @PutMapping("/{idDetalleVenta}")
  @Operation(summary = "Actualizar Detalle de Venta", description = "Actualizar Detalle de Venta")
  public ResponseEntity<DetalleVentaEntity> actualizarDetalleVenta(@PathVariable Integer idDetalleVenta, @RequestBody DetalleVentaEntity detalleVenta) {
    try {
      detalleVenta.setId(idDetalleVenta);
      return ResponseEntity.ok(detalleVentaService.actualizarDetalleVenta(detalleVenta));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
  
  @DeleteMapping("/{idDetalleVenta}")
  @Operation(summary = "Eliminar Detalle de Venta", description = "Eliminar Detalle de Venta")
  public ResponseEntity<Void> eliminarDetalleVenta(@PathVariable Integer idDetalleVenta) {
    try {
      DetalleVentaEntity detalleVenta = detalleVentaService.obtenerDetalleVenta(idDetalleVenta);
      if (detalleVenta != null) {
        detalleVentaService.eliminarDetalleVenta(idDetalleVenta);
        return ResponseEntity.noContent().build();
      } else {
        return ResponseEntity.notFound().build();
      }
    } catch (Exception ex) {
      return ResponseEntity.internalServerError().build();
    }
  }
}

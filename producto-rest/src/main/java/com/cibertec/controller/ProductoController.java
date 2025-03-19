package com.cibertec.controller;

import com.cibertec.entity.ProductoEntity;
import com.cibertec.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/productos")
@RequiredArgsConstructor
@Tag(name = "Producto", description = "API para la gestión de Productos")
public class ProductoController {

    private final ProductoService productoService;

    @Operation(summary = "Obtener todos los productos",
            description = "Obtiene una lista completa de todos los productos disponibles en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Productos encontrados correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class, type = "array"))),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content(schema = @Schema(implementation = List.class)))
    })
    @GetMapping
    public ResponseEntity<List<ProductoEntity>> listarProductos() {
        try {
            List<ProductoEntity> productos = productoService.listarProductos();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @Operation(summary = "Obtener producto por ID",
            description = "Obtiene un producto específico según su identificador único")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Producto encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class))),
            @ApiResponse(responseCode = "400",
                    description = "ID no puede ser nulo o producto no existe",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> productoPorId(
            @Parameter(description = "ID del producto a buscar", required = true, example = "1")
            @PathVariable Integer id) {
        try {
            ProductoEntity producto = productoService.buscarProductoPorId(id);
            return ResponseEntity.ok(producto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().header("Error", e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).header("Error", "Error al obtener el producto").build();
        }
    }

    @Operation(summary = "Registrar Producto",
            description = "Registra un nuevo producto en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Producto registrado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class))),
            @ApiResponse(responseCode = "400",
                    description = "Datos del producto inválidos",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<ProductoEntity> registrarProducto(
            @Parameter(description = "Datos del producto a registrar", required = true,
                    schema = @Schema(implementation = ProductoEntity.class))
            @RequestBody ProductoEntity productoEntity) {
        try {
            ProductoEntity nuevoProducto = productoService.guardarProducto(productoEntity);
            return ResponseEntity.created(
                            URI.create("/api/productos/" + nuevoProducto.getId()))
                    .body(nuevoProducto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().header("Error", e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).header("Error", "Error al guardar el producto").build();
        }
    }

    @Operation(summary = "Actualizar Producto",
            description = "Actualiza un producto existente según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Producto actualizado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class))),
            @ApiResponse(responseCode = "400",
                    description = "Datos del producto inválidos o ID no existe",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductoEntity> actualizarProducto(
            @Parameter(description = "ID del producto a actualizar", required = true, example = "1")
            @PathVariable Integer id,
            @Parameter(description = "Datos actualizados del producto", required = true,
                    schema = @Schema(implementation = ProductoEntity.class))
            @RequestBody ProductoEntity productoEntity) {
        try {
            productoEntity.setId(id);
            ProductoEntity productoActualizado = productoService.guardarProducto(productoEntity);
            return ResponseEntity.ok(productoActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().header("Error", e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).header("Error", "Error al actualizar el producto").build();
        }
    }

    @Operation(summary = "Eliminar Producto",
            description = "Elimina un producto existente según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Producto eliminado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class))),
            @ApiResponse(responseCode = "400",
                    description = "ID no existe o no se puede eliminar el producto",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoEntity> eliminarProducto(
            @Parameter(description = "ID del producto a eliminar", required = true, example = "1")
            @PathVariable Integer id) {
        try {
            ProductoEntity producto = productoService.eliminarProducto(id);
            return ResponseEntity.ok(producto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().header("Error", e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).header("Error", "Error al eliminar el producto").build();
        }
    }

    @Operation(summary = "Buscar producto por código",
            description = "Obtiene un producto específico según su código único")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Producto encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class))),
            @ApiResponse(responseCode = "400",
                    description = "Código no puede ser nulo o producto no existe",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/by-codigo/{codigo}")
    public ResponseEntity<ProductoEntity> buscarPorCodigo(
            @Parameter(description = "Código único del producto", required = true, example = "PROD001")
            @PathVariable String codigo) {
        try {
            ProductoEntity producto = productoService.buscarProductoPorCodigo(codigo);
            return ResponseEntity.ok(producto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().header("Error", e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).header("Error", "Error al obtener el producto").build();
        }
    }

    @Operation(summary = "Buscar productos por nombre",
            description = "Obtiene una lista de productos que contengan el término de búsqueda en su nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Búsqueda completada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class, type = "array"))),
            @ApiResponse(responseCode = "400",
                    description = "Término de búsqueda inválido",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/search")
    public ResponseEntity<List<ProductoEntity>> buscarPorNombre(
            @Parameter(description = "Término a buscar en el nombre del producto", required = true, example = "Samsung")
            @RequestParam String nombre) {
        try {
            List<ProductoEntity> productos = productoService.buscarProductosPorNombre(nombre);
            return ResponseEntity.ok(productos);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().header("Error", e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @Operation(summary = "Listar productos por categoría",
            description = "Obtiene una lista de productos de una categoría específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Productos encontrados",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class, type = "array"))),
            @ApiResponse(responseCode = "400",
                    description = "Categoría inválida",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/by-categoria/{categoria}")
    public ResponseEntity<List<ProductoEntity>> listarPorCategoria(
            @Parameter(description = "Categoría de productos", required = true, example = "Electrónica")
            @PathVariable String categoria) {
        try {
            List<ProductoEntity> productos = productoService.buscarProductosPorCategoria(categoria);
            return ResponseEntity.ok(productos);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().header("Error", e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @Operation(summary = "Listar productos activos",
            description = "Obtiene una lista de todos los productos activos en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Productos activos encontrados",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class, type = "array"))),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/activos")
    public ResponseEntity<List<ProductoEntity>> listarProductosActivos() {
        try {
            List<ProductoEntity> productos = productoService.listarProductosActivos();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @Operation(summary = "Listar productos con stock disponible",
            description = "Obtiene una lista de productos que tienen al menos la cantidad mínima especificada de stock")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Productos con stock encontrados",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoEntity.class, type = "array"))),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/with-stock")
    public ResponseEntity<List<ProductoEntity>> listarProductosConStock(
            @Parameter(description = "Stock mínimo requerido", example = "10")
            @RequestParam(defaultValue = "0") Integer stockMinimo) {
        try {
            List<ProductoEntity> productos = productoService.listarProductosConStock(stockMinimo);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
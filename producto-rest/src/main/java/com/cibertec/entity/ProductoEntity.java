package com.cibertec.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "Producto", description = "Entidad que representa un producto en el sistema")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del producto", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @NotBlank(message = "La marca es obligatoria")
    @Size(min = 2, max = 50, message = "La marca debe tener entre 2 y 50 caracteres")
    @Column(name = "marca", nullable = false, length = 50)
    @Schema(description = "Marca del producto", example = "Samsung", required = true)
    private String marca;

    @NotBlank(message = "El código es obligatorio")
    @Pattern(regexp = "^[A-Z0-9]{4,50}$", message = "El código debe contener entre 4 y 50 caracteres alfanuméricos en mayúsculas")
    @Column(name = "codigo", nullable = false, length = 50, unique = true)
    @Schema(description = "Código único del producto", example = "PROD001", required = true)
    private String codigo;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    @Schema(description = "Nombre del producto", example = "Smartphone Galaxy S21", required = true)
    private String nombre;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(min = 2, max = 50, message = "La categoría debe tener entre 2 y 50 caracteres")
    @Column(name = "categoria", nullable = false, length = 50)
    @Schema(description = "Categoría del producto", example = "Electrónica", required = true)
    private String categoria;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Digits(integer = 8, fraction = 2, message = "El precio debe tener hasta 8 dígitos enteros y 2 decimales")
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    @Schema(description = "Precio unitario del producto", example = "799.99", required = true)
    private BigDecimal precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(name = "stock", nullable = false)
    @Schema(description = "Cantidad disponible en inventario", example = "50", required = true)
    private Integer stock;

    @Column(name = "activo", nullable = false)
    @Schema(description = "Indica si el producto está activo", example = "true", defaultValue = "true")
    private Boolean activo = true;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Schema(description = "Fecha de creación", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Schema(description = "Fecha de última actualización", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        // Asegurar que activo sea true al crear un nuevo producto
        if (activo == null) {
            activo = true;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}


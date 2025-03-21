package com.cibertec.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "ProductoDTO", description = "DTO que representa un producto en el sistema")
public class ProductoDTO {

    private Integer id;

    private String marca;

    private String codigo;

    private String nombre;

    private String categoria;

    private BigDecimal precio;

    private Integer stock;

    private Boolean activo = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
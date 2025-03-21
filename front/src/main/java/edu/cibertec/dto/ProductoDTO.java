package edu.cibertec.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
  private Integer id;
  private String marca;
  private String codigo;
  private String nombre;
  private String categoria;
  private BigDecimal precio;
  private Integer stock;
  private Boolean activo;
}

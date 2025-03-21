package edu.cibertec.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Integer id;
    private Integer idCliente;
    private Integer idUsuario;
    private Timestamp fecha;
    private BigDecimal total;
}

package edu.cibertec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private int id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String email;
    private int telefono;
    private String direccion;
    private Date fechaNacimiento;
}

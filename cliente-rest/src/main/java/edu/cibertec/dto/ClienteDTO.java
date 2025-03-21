package edu.cibertec.dto;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="ClienteDTO", description = "Entity de Cliente")
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

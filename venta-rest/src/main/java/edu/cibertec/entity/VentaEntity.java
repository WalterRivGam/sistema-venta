package edu.cibertec.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
@Schema(name = "Ventas", description = "Entity de Ventas")
public class VentaEntity extends RepresentationModel<VentaEntity> implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cliente_id")
    private Integer idCliente;
    
    @Column(name = "usuario_id")
    private Integer idUsuario;
    
    @CreationTimestamp
    @Column(name = "fecha")
    private Timestamp fecha;
    
    @Column(name = "total")
    private BigDecimal total;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}

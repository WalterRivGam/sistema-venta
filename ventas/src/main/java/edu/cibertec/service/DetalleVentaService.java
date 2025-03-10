package edu.cibertec.service;

import java.util.List;
import edu.cibertec.entity.DetalleVentaEntity;

public interface DetalleVentaService {
    List<DetalleVentaEntity> listarDetallesVenta();
    DetalleVentaEntity obtenerDetalleVenta(Integer idDetalleVenta);
    DetalleVentaEntity registrarDetalleVenta(DetalleVentaEntity detalleVenta);
    DetalleVentaEntity actualizarDetalleVenta(DetalleVentaEntity detalleVenta);
    void eliminarDetalleVenta(Integer idDetalleVenta);
}

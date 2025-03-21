package edu.cibertec.repository;

import java.util.List;
import edu.cibertec.dto.DetalleVentaDTO;

public interface DetalleVentaRepository {
    public List<DetalleVentaDTO> listarDetallesVenta();
    public DetalleVentaDTO obtenerDetalleVenta(Integer idDetalleVenta);
    public DetalleVentaDTO registrarDetalleVenta(DetalleVentaDTO detalleVenta);
    public void actualizarDetalleVenta(DetalleVentaDTO detalleVenta);
    public void eliminarDetalleVenta(Integer idDetalleVenta);
}

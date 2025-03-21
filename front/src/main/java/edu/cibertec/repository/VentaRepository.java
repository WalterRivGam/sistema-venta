package edu.cibertec.repository;

import java.util.List;

import edu.cibertec.dto.VentaDTO;

public interface VentaRepository {
  public List<VentaDTO> listarventas();
  public VentaDTO obtenerVenta(Integer idVenta);
  public VentaDTO registrarVenta(VentaDTO venta);
  public void actualizarVenta(VentaDTO venta);
  public void eliminarVenta(Integer idVenta);
}

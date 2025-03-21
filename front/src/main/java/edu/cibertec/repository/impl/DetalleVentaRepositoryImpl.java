package edu.cibertec.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.dto.DetalleVentaDTO;
import edu.cibertec.repository.DetalleVentaRepository;

@Repository
public class DetalleVentaRepositoryImpl implements DetalleVentaRepository {

    private RestTemplate restTemplate;

    @Value("${url.api}")
    private String urlApi;

    public DetalleVentaRepositoryImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<DetalleVentaDTO> listarDetallesVenta() {
        return restTemplate.getForObject(urlApi + "/detalles-venta", List.class);
    }

    @Override
    public DetalleVentaDTO obtenerDetalleVenta(Integer idDetalleVenta) {
        return restTemplate.getForObject(urlApi + "/detalles-venta/" + idDetalleVenta, DetalleVentaDTO.class);
    }

    @Override
    public DetalleVentaDTO registrarDetalleVenta(DetalleVentaDTO detalleVenta) {
        return restTemplate.postForObject(urlApi + "/detalles-venta", detalleVenta, DetalleVentaDTO.class);
    }

    @Override
    public void actualizarDetalleVenta(DetalleVentaDTO detalleVenta) {
        restTemplate.put(urlApi + "/detalles-venta/" + detalleVenta.getId(), detalleVenta);
    }

    @Override
    public void eliminarDetalleVenta(Integer idDetalleVenta) {
        restTemplate.delete(urlApi + "/detalles-venta/" + idDetalleVenta);
    }
}

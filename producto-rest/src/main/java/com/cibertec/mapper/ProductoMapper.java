package com.cibertec.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.cibertec.dto.ProductoDTO;
import com.cibertec.entity.ProductoEntity;

@Mapper(componentModel = "spring")
@Component
public interface ProductoMapper {
    ProductoEntity convertirDTOAEntity(ProductoDTO productoDTO);
    ProductoDTO convertirEntityADTO(ProductoEntity productoEntity);
    List<ProductoEntity> convertirDTOAEntity(List<ProductoDTO> productoDTO);
    List<ProductoDTO> convertirEntityADTO(List<ProductoEntity> productoEntity);
}

package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Devise;
import com.wetic.tactcrm.service.dto.DeviseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeviseMapper extends EntiteMapper<DeviseDTO, Devise> {


    DeviseDTO toDto(Devise entity);


    @Mapping(target = "depenses", ignore = true)
    @Mapping(target = "factures", ignore = true)
    Devise toEntity(DeviseDTO dto);


    default Devise fromId(Long id) {
        if (id == null) {
            return null;
        }
        Devise devise = new Devise();
        devise.setId(id);
        return devise;
    }

}

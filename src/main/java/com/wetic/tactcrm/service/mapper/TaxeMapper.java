package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Taxe;
import com.wetic.tactcrm.service.dto.TaxeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaxeMapper extends EntiteMapper<TaxeDTO, Taxe>{


    @Override
    TaxeDTO toDto(Taxe entity);

    //    source = dto
    // target = entity
    @Mapping(target = "factures", ignore = true)
    @Mapping(target = "articles", ignore = true)
    Taxe toEntity(TaxeDTO dto);

    default Taxe fromId(Long id) {
        if (id == null) {
            return null;
        }
        Taxe taxe = new Taxe();
        taxe.setId(id);
        return taxe;
    }
}

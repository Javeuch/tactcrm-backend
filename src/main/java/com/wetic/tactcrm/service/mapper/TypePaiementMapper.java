package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.TypePaiement;
import com.wetic.tactcrm.service.dto.TypePaiementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TypePaiementMapper extends EntiteMapper<TypePaiementDTO, TypePaiement> {

    TypePaiementDTO toDto(TypePaiement entity);

    @Mapping(target = "factures", ignore = true)
    @Mapping(target = "depenses", ignore = true)
    TypePaiement toEntity(TypePaiementDTO dto);

    default TypePaiement fromId(Long id) {
        if (id == null) {
            return null;
        }
        TypePaiement typePaiement = new TypePaiement();
        typePaiement.setId(id);
        return typePaiement;
    }


}

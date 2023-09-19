package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Depense;
import com.wetic.tactcrm.service.dto.DepenseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TypeDepenseMapper.class, TypePaiementMapper.class, DeviseMapper.class})
public interface DepenseMapper extends EntiteMapper<DepenseDTO, Depense> {

    @Mapping(source = "typeDepense.id", target = "typeDepenseId")
    @Mapping(source = "typePaiement.id", target = "typePaiementId")
    @Mapping(source = "devise.id", target = "deviseId")
    DepenseDTO toDto(Depense depense);


    @Mapping(source = "typeDepenseId", target = "typeDepense")
    @Mapping(source = "typePaiementId", target = "typePaiement")
    @Mapping(source = "deviseId", target = "devise")
    Depense toEntity(DepenseDTO articleDTO);
}

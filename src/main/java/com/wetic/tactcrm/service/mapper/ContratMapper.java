package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Contrat;
import com.wetic.tactcrm.domain.Depense;
import com.wetic.tactcrm.service.dto.ContratDTO;
import com.wetic.tactcrm.service.dto.DepenseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class})
public interface ContratMapper extends EntiteMapper<ContratDTO, Contrat> {

    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    ContratDTO toDto(Contrat depense);



    @Mapping(source = "utilisateurId", target = "utilisateur")
    Contrat toEntity(ContratDTO articleDTO);





}

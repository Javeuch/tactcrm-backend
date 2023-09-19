package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Adresse;
import com.wetic.tactcrm.service.dto.AdresseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class})
public interface AdresseMapper extends EntiteMapper<AdresseDTO, Adresse> {


    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    AdresseDTO toDto(Adresse entity);

    @Mapping(source = "utilisateurId", target = "utilisateur")
    Adresse toEntity(AdresseDTO dto);


    default Adresse fromId(Long id) {
        if (id == null) {
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setId(id);
        return adresse;
    }
}

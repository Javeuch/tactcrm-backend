package com.wetic.tactcrm.service.mapper;


import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.service.dto.CreateOrEditUtilisateurDTO;
import com.wetic.tactcrm.service.dto.UtilisateurDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AdresseMapper.class})
public interface UtilisateurMapper extends EntiteMapper<UtilisateurDTO, Utilisateur> {

    @Mapping(source = "adresse.id", target = "adresseId")
    UtilisateurDTO toDto(Utilisateur utilisateur);

    @Mapping(source = "adresseId", target = "adresse")
    @Mapping(target = "factures", ignore = true)
    @Mapping(target = "contrats", ignore = true)
    Utilisateur toEntity(UtilisateurDTO utilisateurDto);

    @Mapping(source = "adresseId", target = "adresse")
    Utilisateur toEntity(CreateOrEditUtilisateurDTO utilisateurDto);

    default Utilisateur fromId(Long id) {
        if (id == null) {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(id);
        return utilisateur;
    }

}

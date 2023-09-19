package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Facture;
import com.wetic.tactcrm.service.dto.FactureDTO;
import com.wetic.tactcrm.service.dto.FactureViewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" ,uses = {DeviseMapper.class, TaxeMapper.class, UtilisateurMapper.class, TypePaiementMapper.class})
public interface FactureMapper extends EntiteMapper<FactureDTO, Facture> {

    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    @Mapping(source = "devise.id", target = "deviseId")
    @Mapping(source = "taxe.id", target = "taxeId")
    @Mapping(source = "typePaiement.id", target = "typePaiementId")
    @Mapping(source = "taxe.nom", target = "taxeNom")
    @Mapping(source = "typePaiement.nom", target = "typePaiementNom")
    @Mapping(source = "utilisateur.nom", target = "utilisateurNom")
    FactureDTO toDto(Facture entity);


    @Mapping(source = "utilisateurId", target = "utilisateur")
    @Mapping(source = "deviseId", target = "devise")
    @Mapping(source = "taxeId", target = "taxe")
    @Mapping(source = "typePaiementId", target = "typePaiement")
    @Mapping(target = "detailsFactures", ignore = true)
    Facture toEntity(FactureDTO dto);

    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    @Mapping(source = "devise.id", target = "deviseId")
    @Mapping(source = "taxe.id", target = "taxeId")
    @Mapping(source = "typePaiement", target = "typePaiementDTO")
    @Mapping(source = "utilisateur", target = "utilisateurDTO")
    @Mapping(source = "utilisateur.adresse", target = "clientAdressDTO")
    @Mapping(source = "devise", target = "deviseDTO")
    @Mapping(target = "utilisateurDTO.password", ignore = true)
    FactureViewDTO toFactureViewDto(Facture entity);

    default Facture fromId(Long id) {
        if (id == null) {
            return null;
        }
        Facture facture = new Facture();
        facture.setId(id);
        return facture;
    }
}

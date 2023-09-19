package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Adresse;
import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.service.dto.AdresseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:33+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class AdresseMapperImpl implements AdresseMapper {

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Override
    public List<Adresse> toEntity(List<AdresseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Adresse> list = new ArrayList<Adresse>( dtoList.size() );
        for ( AdresseDTO adresseDTO : dtoList ) {
            list.add( toEntity( adresseDTO ) );
        }

        return list;
    }

    @Override
    public List<AdresseDTO> toDto(List<Adresse> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AdresseDTO> list = new ArrayList<AdresseDTO>( entityList.size() );
        for ( Adresse adresse : entityList ) {
            list.add( toDto( adresse ) );
        }

        return list;
    }

    @Override
    public AdresseDTO toDto(Adresse entity) {
        if ( entity == null ) {
            return null;
        }

        AdresseDTO adresseDTO = new AdresseDTO();

        adresseDTO.setUtilisateurId( entityUtilisateurId( entity ) );
        adresseDTO.setId( entity.getId() );
        adresseDTO.setRue( entity.getRue() );
        adresseDTO.setLocalite( entity.getLocalite() );
        adresseDTO.setPays( entity.getPays() );
        adresseDTO.setVille( entity.getVille() );

        return adresseDTO;
    }

    @Override
    public Adresse toEntity(AdresseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Adresse adresse = new Adresse();

        adresse.setUtilisateur( utilisateurMapper.fromId( dto.getUtilisateurId() ) );
        adresse.setId( dto.getId() );
        adresse.setRue( dto.getRue() );
        adresse.setLocalite( dto.getLocalite() );
        adresse.setPays( dto.getPays() );
        adresse.setVille( dto.getVille() );

        return adresse;
    }

    private Long entityUtilisateurId(Adresse adresse) {
        if ( adresse == null ) {
            return null;
        }
        Utilisateur utilisateur = adresse.getUtilisateur();
        if ( utilisateur == null ) {
            return null;
        }
        Long id = utilisateur.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

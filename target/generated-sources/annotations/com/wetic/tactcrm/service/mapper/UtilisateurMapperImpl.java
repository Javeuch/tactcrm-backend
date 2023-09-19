package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Adresse;
import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.service.dto.CreateOrEditUtilisateurDTO;
import com.wetic.tactcrm.service.dto.UtilisateurDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:31+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Autowired
    private AdresseMapper adresseMapper;

    @Override
    public List<Utilisateur> toEntity(List<UtilisateurDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Utilisateur> list = new ArrayList<Utilisateur>( dtoList.size() );
        for ( UtilisateurDTO utilisateurDTO : dtoList ) {
            list.add( toEntity( utilisateurDTO ) );
        }

        return list;
    }

    @Override
    public List<UtilisateurDTO> toDto(List<Utilisateur> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UtilisateurDTO> list = new ArrayList<UtilisateurDTO>( entityList.size() );
        for ( Utilisateur utilisateur : entityList ) {
            list.add( toDto( utilisateur ) );
        }

        return list;
    }

    @Override
    public UtilisateurDTO toDto(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();

        utilisateurDTO.setAdresseId( utilisateurAdresseId( utilisateur ) );
        utilisateurDTO.setAdmin( utilisateur.getAdmin() );
        utilisateurDTO.setId( utilisateur.getId() );
        utilisateurDTO.setNom( utilisateur.getNom() );
        utilisateurDTO.setPrenom( utilisateur.getPrenom() );
        utilisateurDTO.setLogin( utilisateur.getLogin() );
        utilisateurDTO.setPassword( utilisateur.getPassword() );
        utilisateurDTO.setEmail( utilisateur.getEmail() );
        utilisateurDTO.setTelephone( utilisateur.getTelephone() );

        return utilisateurDTO;
    }

    @Override
    public Utilisateur toEntity(UtilisateurDTO utilisateurDto) {
        if ( utilisateurDto == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setAdresse( adresseMapper.fromId( utilisateurDto.getAdresseId() ) );
        utilisateur.setAdmin( utilisateurDto.getAdmin() );
        utilisateur.setId( utilisateurDto.getId() );
        utilisateur.setNom( utilisateurDto.getNom() );
        utilisateur.setPrenom( utilisateurDto.getPrenom() );
        utilisateur.setLogin( utilisateurDto.getLogin() );
        utilisateur.setPassword( utilisateurDto.getPassword() );
        utilisateur.setEmail( utilisateurDto.getEmail() );
        utilisateur.setTelephone( utilisateurDto.getTelephone() );

        return utilisateur;
    }

    @Override
    public Utilisateur toEntity(CreateOrEditUtilisateurDTO utilisateurDto) {
        if ( utilisateurDto == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setAdresse( adresseMapper.fromId( utilisateurDto.getAdresseId() ) );
        utilisateur.setAdmin( utilisateurDto.getAdmin() );
        utilisateur.setId( utilisateurDto.getId() );
        utilisateur.setNom( utilisateurDto.getNom() );
        utilisateur.setPrenom( utilisateurDto.getPrenom() );
        utilisateur.setLogin( utilisateurDto.getLogin() );
        utilisateur.setPassword( utilisateurDto.getPassword() );
        utilisateur.setEmail( utilisateurDto.getEmail() );
        utilisateur.setTelephone( utilisateurDto.getTelephone() );

        return utilisateur;
    }

    private Long utilisateurAdresseId(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }
        Adresse adresse = utilisateur.getAdresse();
        if ( adresse == null ) {
            return null;
        }
        Long id = adresse.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Contrat;
import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.service.dto.ContratDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:32+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class ContratMapperImpl implements ContratMapper {

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Override
    public List<Contrat> toEntity(List<ContratDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Contrat> list = new ArrayList<Contrat>( dtoList.size() );
        for ( ContratDTO contratDTO : dtoList ) {
            list.add( toEntity( contratDTO ) );
        }

        return list;
    }

    @Override
    public List<ContratDTO> toDto(List<Contrat> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ContratDTO> list = new ArrayList<ContratDTO>( entityList.size() );
        for ( Contrat contrat : entityList ) {
            list.add( toDto( contrat ) );
        }

        return list;
    }

    @Override
    public ContratDTO toDto(Contrat depense) {
        if ( depense == null ) {
            return null;
        }

        ContratDTO contratDTO = new ContratDTO();

        contratDTO.setUtilisateurId( depenseUtilisateurId( depense ) );
        contratDTO.setCreePar( depense.getCreePar() );
        contratDTO.setDateCreation( depense.getDateCreation() );
        contratDTO.setModifiePar( depense.getModifiePar() );
        contratDTO.setDateModification( depense.getDateModification() );
        contratDTO.setId( depense.getId() );
        contratDTO.setSujet( depense.getSujet() );
        contratDTO.setDateDebut( depense.getDateDebut() );
        contratDTO.setDateFin( depense.getDateFin() );
        contratDTO.setDescription( depense.getDescription() );
        contratDTO.setTypeContrat( depense.getTypeContrat() );

        return contratDTO;
    }

    @Override
    public Contrat toEntity(ContratDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        Contrat contrat = new Contrat();

        contrat.setUtilisateur( utilisateurMapper.fromId( articleDTO.getUtilisateurId() ) );
        contrat.setCreePar( articleDTO.getCreePar() );
        contrat.setDateCreation( articleDTO.getDateCreation() );
        contrat.setModifiePar( articleDTO.getModifiePar() );
        contrat.setDateModification( articleDTO.getDateModification() );
        contrat.setId( articleDTO.getId() );
        contrat.setSujet( articleDTO.getSujet() );
        contrat.setDateDebut( articleDTO.getDateDebut() );
        contrat.setDateFin( articleDTO.getDateFin() );
        contrat.setDescription( articleDTO.getDescription() );
        contrat.setTypeContrat( articleDTO.getTypeContrat() );

        return contrat;
    }

    private Long depenseUtilisateurId(Contrat contrat) {
        if ( contrat == null ) {
            return null;
        }
        Utilisateur utilisateur = contrat.getUtilisateur();
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

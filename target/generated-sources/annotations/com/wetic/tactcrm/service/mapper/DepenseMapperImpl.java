package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Depense;
import com.wetic.tactcrm.domain.Devise;
import com.wetic.tactcrm.domain.TypeDepense;
import com.wetic.tactcrm.domain.TypePaiement;
import com.wetic.tactcrm.service.dto.DepenseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:30+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class DepenseMapperImpl implements DepenseMapper {

    @Autowired
    private TypeDepenseMapper typeDepenseMapper;
    @Autowired
    private TypePaiementMapper typePaiementMapper;
    @Autowired
    private DeviseMapper deviseMapper;

    @Override
    public List<Depense> toEntity(List<DepenseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Depense> list = new ArrayList<Depense>( dtoList.size() );
        for ( DepenseDTO depenseDTO : dtoList ) {
            list.add( toEntity( depenseDTO ) );
        }

        return list;
    }

    @Override
    public List<DepenseDTO> toDto(List<Depense> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DepenseDTO> list = new ArrayList<DepenseDTO>( entityList.size() );
        for ( Depense depense : entityList ) {
            list.add( toDto( depense ) );
        }

        return list;
    }

    @Override
    public DepenseDTO toDto(Depense depense) {
        if ( depense == null ) {
            return null;
        }

        DepenseDTO depenseDTO = new DepenseDTO();

        depenseDTO.setTypeDepenseId( depenseTypeDepenseId( depense ) );
        depenseDTO.setTypePaiementId( depenseTypePaiementId( depense ) );
        depenseDTO.setDeviseId( depenseDeviseId( depense ) );
        depenseDTO.setId( depense.getId() );
        depenseDTO.setNom( depense.getNom() );
        depenseDTO.setDateDepense( depense.getDateDepense() );
        depenseDTO.setDescription( depense.getDescription() );
        depenseDTO.setMontant( depense.getMontant() );

        return depenseDTO;
    }

    @Override
    public Depense toEntity(DepenseDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        Depense depense = new Depense();

        depense.setTypeDepense( typeDepenseMapper.fromId( articleDTO.getTypeDepenseId() ) );
        depense.setDevise( deviseMapper.fromId( articleDTO.getDeviseId() ) );
        depense.setTypePaiement( typePaiementMapper.fromId( articleDTO.getTypePaiementId() ) );
        depense.setId( articleDTO.getId() );
        depense.setNom( articleDTO.getNom() );
        depense.setDateDepense( articleDTO.getDateDepense() );
        depense.setDescription( articleDTO.getDescription() );
        depense.setMontant( articleDTO.getMontant() );

        return depense;
    }

    private Long depenseTypeDepenseId(Depense depense) {
        if ( depense == null ) {
            return null;
        }
        TypeDepense typeDepense = depense.getTypeDepense();
        if ( typeDepense == null ) {
            return null;
        }
        Long id = typeDepense.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long depenseTypePaiementId(Depense depense) {
        if ( depense == null ) {
            return null;
        }
        TypePaiement typePaiement = depense.getTypePaiement();
        if ( typePaiement == null ) {
            return null;
        }
        Long id = typePaiement.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long depenseDeviseId(Depense depense) {
        if ( depense == null ) {
            return null;
        }
        Devise devise = depense.getDevise();
        if ( devise == null ) {
            return null;
        }
        Long id = devise.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

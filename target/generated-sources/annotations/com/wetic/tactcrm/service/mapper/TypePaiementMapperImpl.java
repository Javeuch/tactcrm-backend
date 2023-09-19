package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.TypePaiement;
import com.wetic.tactcrm.service.dto.TypePaiementDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:34+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class TypePaiementMapperImpl implements TypePaiementMapper {

    @Override
    public List<TypePaiement> toEntity(List<TypePaiementDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TypePaiement> list = new ArrayList<TypePaiement>( dtoList.size() );
        for ( TypePaiementDTO typePaiementDTO : dtoList ) {
            list.add( toEntity( typePaiementDTO ) );
        }

        return list;
    }

    @Override
    public List<TypePaiementDTO> toDto(List<TypePaiement> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TypePaiementDTO> list = new ArrayList<TypePaiementDTO>( entityList.size() );
        for ( TypePaiement typePaiement : entityList ) {
            list.add( toDto( typePaiement ) );
        }

        return list;
    }

    @Override
    public TypePaiementDTO toDto(TypePaiement entity) {
        if ( entity == null ) {
            return null;
        }

        TypePaiementDTO typePaiementDTO = new TypePaiementDTO();

        typePaiementDTO.setNom( entity.getNom() );
        typePaiementDTO.setId( entity.getId() );
        typePaiementDTO.setDescription( entity.getDescription() );

        return typePaiementDTO;
    }

    @Override
    public TypePaiement toEntity(TypePaiementDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TypePaiement typePaiement = new TypePaiement();

        typePaiement.setId( dto.getId() );
        typePaiement.setNom( dto.getNom() );
        typePaiement.setDescription( dto.getDescription() );

        return typePaiement;
    }
}

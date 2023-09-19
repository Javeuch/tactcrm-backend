package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.TypeDepense;
import com.wetic.tactcrm.service.dto.TypeDepenseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:28+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class TypeDepenseMapperImpl implements TypeDepenseMapper {

    @Override
    public List<TypeDepense> toEntity(List<TypeDepenseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TypeDepense> list = new ArrayList<TypeDepense>( dtoList.size() );
        for ( TypeDepenseDTO typeDepenseDTO : dtoList ) {
            list.add( toEntity( typeDepenseDTO ) );
        }

        return list;
    }

    @Override
    public List<TypeDepenseDTO> toDto(List<TypeDepense> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TypeDepenseDTO> list = new ArrayList<TypeDepenseDTO>( entityList.size() );
        for ( TypeDepense typeDepense : entityList ) {
            list.add( toDto( typeDepense ) );
        }

        return list;
    }

    @Override
    public TypeDepenseDTO toDto(TypeDepense entity) {
        if ( entity == null ) {
            return null;
        }

        TypeDepenseDTO typeDepenseDTO = new TypeDepenseDTO();

        typeDepenseDTO.setId( entity.getId() );
        typeDepenseDTO.setNom( entity.getNom() );
        typeDepenseDTO.setDescription( entity.getDescription() );

        return typeDepenseDTO;
    }

    @Override
    public TypeDepense toEntity(TypeDepenseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TypeDepense typeDepense = new TypeDepense();

        typeDepense.setNom( dto.getNom() );
        typeDepense.setId( dto.getId() );
        typeDepense.setDescription( dto.getDescription() );

        return typeDepense;
    }
}

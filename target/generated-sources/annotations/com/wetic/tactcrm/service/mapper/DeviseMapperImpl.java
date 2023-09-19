package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Devise;
import com.wetic.tactcrm.service.dto.DeviseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:35+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class DeviseMapperImpl implements DeviseMapper {

    @Override
    public List<Devise> toEntity(List<DeviseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Devise> list = new ArrayList<Devise>( dtoList.size() );
        for ( DeviseDTO deviseDTO : dtoList ) {
            list.add( toEntity( deviseDTO ) );
        }

        return list;
    }

    @Override
    public List<DeviseDTO> toDto(List<Devise> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DeviseDTO> list = new ArrayList<DeviseDTO>( entityList.size() );
        for ( Devise devise : entityList ) {
            list.add( toDto( devise ) );
        }

        return list;
    }

    @Override
    public DeviseDTO toDto(Devise entity) {
        if ( entity == null ) {
            return null;
        }

        DeviseDTO deviseDTO = new DeviseDTO();

        deviseDTO.setNom( entity.getNom() );
        deviseDTO.setSymbole( entity.getSymbole() );
        deviseDTO.setId( entity.getId() );

        return deviseDTO;
    }

    @Override
    public Devise toEntity(DeviseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Devise devise = new Devise();

        devise.setId( dto.getId() );
        devise.setNom( dto.getNom() );
        devise.setSymbole( dto.getSymbole() );

        return devise;
    }
}

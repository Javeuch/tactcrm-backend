package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Taxe;
import com.wetic.tactcrm.service.dto.TaxeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:29+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class TaxeMapperImpl implements TaxeMapper {

    @Override
    public List<Taxe> toEntity(List<TaxeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Taxe> list = new ArrayList<Taxe>( dtoList.size() );
        for ( TaxeDTO taxeDTO : dtoList ) {
            list.add( toEntity( taxeDTO ) );
        }

        return list;
    }

    @Override
    public List<TaxeDTO> toDto(List<Taxe> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TaxeDTO> list = new ArrayList<TaxeDTO>( entityList.size() );
        for ( Taxe taxe : entityList ) {
            list.add( toDto( taxe ) );
        }

        return list;
    }

    @Override
    public TaxeDTO toDto(Taxe entity) {
        if ( entity == null ) {
            return null;
        }

        TaxeDTO taxeDTO = new TaxeDTO();

        taxeDTO.setNom( entity.getNom() );
        taxeDTO.setId( entity.getId() );
        taxeDTO.setTaux( entity.getTaux() );

        return taxeDTO;
    }

    @Override
    public Taxe toEntity(TaxeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Taxe taxe = new Taxe();

        taxe.setId( dto.getId() );
        taxe.setTaux( dto.getTaux() );
        taxe.setNom( dto.getNom() );

        return taxe;
    }
}

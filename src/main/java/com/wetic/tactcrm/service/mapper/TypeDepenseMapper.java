package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.TypeDepense;
import com.wetic.tactcrm.service.dto.TypeDepenseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TypeDepenseMapper extends EntiteMapper<TypeDepenseDTO, TypeDepense> {


    TypeDepenseDTO toDto(TypeDepense entity);

    @Mapping(target = "depenses", ignore = true)
    TypeDepense toEntity(TypeDepenseDTO dto);

    default TypeDepense fromId(Long id) {
        if (id == null) {
            return null;
        }
        TypeDepense depenseDepense = new TypeDepense();
        depenseDepense.setId(id);
        return depenseDepense;
    }
}

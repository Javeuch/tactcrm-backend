package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.DetailsFacture;
import com.wetic.tactcrm.service.dto.DetailsFactureDTO;
import com.wetic.tactcrm.service.dto.FactureDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FactureMapper.class, ArticleMapper.class, TaxeMapper.class})
public interface DetailsFactureMapper extends EntiteMapper<DetailsFactureDTO, DetailsFacture> {

    @Mapping(source = "facture.id", target = "factureId")
    @Mapping(source = "article.id", target = "articleId")
    @Mapping(source = "article.designation", target = "articleDesignation")
    @Mapping(source = "article.taxe", target = "taxeDto")
    DetailsFactureDTO toDto(DetailsFacture entity);

    @Mapping(source = "factureId", target = "facture")
    @Mapping(source = "articleId", target = "article")
    DetailsFacture toEntity(DetailsFactureDTO dto);


}

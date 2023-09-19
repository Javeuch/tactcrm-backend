package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Article;
import com.wetic.tactcrm.domain.DetailsFacture;
import com.wetic.tactcrm.domain.Facture;
import com.wetic.tactcrm.domain.Taxe;
import com.wetic.tactcrm.service.dto.DetailsFactureDTO;
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
public class DetailsFactureMapperImpl implements DetailsFactureMapper {

    @Autowired
    private FactureMapper factureMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TaxeMapper taxeMapper;

    @Override
    public List<DetailsFacture> toEntity(List<DetailsFactureDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DetailsFacture> list = new ArrayList<DetailsFacture>( dtoList.size() );
        for ( DetailsFactureDTO detailsFactureDTO : dtoList ) {
            list.add( toEntity( detailsFactureDTO ) );
        }

        return list;
    }

    @Override
    public List<DetailsFactureDTO> toDto(List<DetailsFacture> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DetailsFactureDTO> list = new ArrayList<DetailsFactureDTO>( entityList.size() );
        for ( DetailsFacture detailsFacture : entityList ) {
            list.add( toDto( detailsFacture ) );
        }

        return list;
    }

    @Override
    public DetailsFactureDTO toDto(DetailsFacture entity) {
        if ( entity == null ) {
            return null;
        }

        DetailsFactureDTO detailsFactureDTO = new DetailsFactureDTO();

        detailsFactureDTO.setFactureId( entityFactureId( entity ) );
        detailsFactureDTO.setArticleId( entityArticleId( entity ) );
        detailsFactureDTO.setArticleDesignation( entityArticleDesignation( entity ) );
        detailsFactureDTO.setTaxeDto( taxeMapper.toDto( entityArticleTaxe( entity ) ) );
        detailsFactureDTO.setPrixFactureHt( entity.getPrixFactureHt() );
        detailsFactureDTO.setQuantite( entity.getQuantite() );
        detailsFactureDTO.setId( entity.getId() );

        return detailsFactureDTO;
    }

    @Override
    public DetailsFacture toEntity(DetailsFactureDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DetailsFacture detailsFacture = new DetailsFacture();

        detailsFacture.setArticle( articleMapper.fromId( dto.getArticleId() ) );
        detailsFacture.setFacture( factureMapper.fromId( dto.getFactureId() ) );
        detailsFacture.setId( dto.getId() );
        detailsFacture.setPrixFactureHt( dto.getPrixFactureHt() );
        detailsFacture.setQuantite( dto.getQuantite() );

        return detailsFacture;
    }

    private Long entityFactureId(DetailsFacture detailsFacture) {
        if ( detailsFacture == null ) {
            return null;
        }
        Facture facture = detailsFacture.getFacture();
        if ( facture == null ) {
            return null;
        }
        Long id = facture.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityArticleId(DetailsFacture detailsFacture) {
        if ( detailsFacture == null ) {
            return null;
        }
        Article article = detailsFacture.getArticle();
        if ( article == null ) {
            return null;
        }
        Long id = article.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityArticleDesignation(DetailsFacture detailsFacture) {
        if ( detailsFacture == null ) {
            return null;
        }
        Article article = detailsFacture.getArticle();
        if ( article == null ) {
            return null;
        }
        String designation = article.getDesignation();
        if ( designation == null ) {
            return null;
        }
        return designation;
    }

    private Taxe entityArticleTaxe(DetailsFacture detailsFacture) {
        if ( detailsFacture == null ) {
            return null;
        }
        Article article = detailsFacture.getArticle();
        if ( article == null ) {
            return null;
        }
        Taxe taxe = article.getTaxe();
        if ( taxe == null ) {
            return null;
        }
        return taxe;
    }
}

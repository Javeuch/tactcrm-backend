package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Article;
import com.wetic.tactcrm.domain.Taxe;
import com.wetic.tactcrm.service.dto.ArticleDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:34+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class ArticleMapperImpl implements ArticleMapper {

    @Autowired
    private TaxeMapper taxeMapper;

    @Override
    public List<Article> toEntity(List<ArticleDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Article> list = new ArrayList<Article>( dtoList.size() );
        for ( ArticleDTO articleDTO : dtoList ) {
            list.add( toEntity( articleDTO ) );
        }

        return list;
    }

    @Override
    public List<ArticleDTO> toDto(List<Article> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ArticleDTO> list = new ArrayList<ArticleDTO>( entityList.size() );
        for ( Article article : entityList ) {
            list.add( toDto( article ) );
        }

        return list;
    }

    @Override
    public ArticleDTO toDto(Article article) {
        if ( article == null ) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setTaxeId( articleTaxeId( article ) );
        articleDTO.setTaxeDto( taxeMapper.toDto( article.getTaxe() ) );
        articleDTO.setId( article.getId() );
        articleDTO.setDesignation( article.getDesignation() );
        articleDTO.setPrixVente( article.getPrixVente() );

        return articleDTO;
    }

    @Override
    public Article toEntity(ArticleDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        Article article = new Article();

        article.setTaxe( articleDTOToTaxe( articleDTO ) );
        article.setId( articleDTO.getId() );
        article.setDesignation( articleDTO.getDesignation() );
        article.setPrixVente( articleDTO.getPrixVente() );

        return article;
    }

    private Long articleTaxeId(Article article) {
        if ( article == null ) {
            return null;
        }
        Taxe taxe = article.getTaxe();
        if ( taxe == null ) {
            return null;
        }
        Long id = taxe.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Taxe articleDTOToTaxe(ArticleDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        Taxe taxe = new Taxe();

        taxe.setId( articleDTO.getTaxeId() );

        return taxe;
    }
}

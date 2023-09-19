package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Article;
import com.wetic.tactcrm.service.dto.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TaxeMapper.class})
public interface ArticleMapper extends EntiteMapper<ArticleDTO, Article> {

    @Mapping(source = "taxe.id", target = "taxeId")
    @Mapping(source = "taxe", target = "taxeDto")
    ArticleDTO toDto(Article article);



    @Mapping(source = "taxeId", target = "taxe.id")
    @Mapping(target = "detailsFactures", ignore = true)
    Article toEntity(ArticleDTO articleDTO);

    default Article fromId(Long id) {
        if (id == null) {
            return null;
        }
        Article article = new Article();
        article.setId(id);
        return article;
    }
}

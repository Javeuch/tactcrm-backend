package com.wetic.tactcrm.service;

import com.wetic.tactcrm.service.dto.ArticleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    ArticleDTO save(ArticleDTO articleDTO);

    Page<ArticleDTO> findAll(Pageable pageable);

    List<ArticleDTO> findAllAsList();


    Optional<ArticleDTO> findOne(Long id);

    void delete(Long id);

}

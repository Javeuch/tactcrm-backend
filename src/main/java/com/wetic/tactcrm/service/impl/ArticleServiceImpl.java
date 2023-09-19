package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.Article;
import com.wetic.tactcrm.repository.ArticleRepository;
import com.wetic.tactcrm.service.ArticleService;
import com.wetic.tactcrm.service.dto.ArticleDTO;
import com.wetic.tactcrm.service.mapper.ArticleMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }


    @Override
    public ArticleDTO save(ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO);
        article = articleRepository.save(article);
        return articleMapper.toDto(article);
    }

    @Override
    public Page<ArticleDTO> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable)
                .map(articleMapper::toDto);
    }

    @Override
    public List<ArticleDTO> findAllAsList() {
        return articleRepository.findAll()
                .stream()
                .map(articleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ArticleDTO> findOne(Long id) {
        return articleRepository.findById(id)
                .map(articleMapper::toDto);

    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}

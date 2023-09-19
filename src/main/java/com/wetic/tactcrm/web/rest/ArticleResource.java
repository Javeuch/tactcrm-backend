package com.wetic.tactcrm.web.rest;

import com.wetic.tactcrm.domain.Article;
import com.wetic.tactcrm.repository.ArticleRepository;
import com.wetic.tactcrm.service.ArticleService;
import com.wetic.tactcrm.service.dto.ArticleDTO;
import com.wetic.tactcrm.web.util.RestUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ArticleResource {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    public ArticleResource(ArticleRepository articleRepository, ArticleService service) {
        this.articleRepository = articleRepository;
        this.articleService = service;
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDTO>> getAllArticle(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<ArticleDTO> page = articleService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleDTO> getTypeDepense(@PathVariable Long id) {
        Optional<ArticleDTO> typeDepenseDTO = articleService.findOne(id);
        return RestUtils.wrapOrNotFound(typeDepenseDTO, null);
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleDTO> createArticle(@Valid @RequestBody ArticleDTO articleDTO) throws URISyntaxException {
        ArticleDTO result  = articleService.save(articleDTO);
        return ResponseEntity.created(new URI("/api/articles" + result.getId()))
                .body(result);
    }

    @PutMapping("/articles")
    public ResponseEntity<ArticleDTO> updateArticle(@Valid @RequestBody ArticleDTO articleDTO) throws URISyntaxException {
        if (articleDTO.getId()==null){
            return null;
        }
        ArticleDTO result = articleService.save(articleDTO);
        return ResponseEntity.created(new URI("/api/articles" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) throws URISyntaxException{

        articleService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/articles/all")
    public ResponseEntity<List<ArticleDTO>> getAllTaxe(){
        List<ArticleDTO> articlesDepense = articleService.findAllAsList();
        return ResponseEntity.ok().body(articlesDepense);
    }


}

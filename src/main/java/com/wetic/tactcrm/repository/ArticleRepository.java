package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.Article;
import com.wetic.tactcrm.domain.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}

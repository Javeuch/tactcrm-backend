package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.Adresse;
import com.wetic.tactcrm.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Long> {
}

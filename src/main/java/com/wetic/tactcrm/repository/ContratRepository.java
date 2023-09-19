package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.Contrat;
import com.wetic.tactcrm.domain.TypeDepense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {


    public Page<Contrat> findByUtilisateurId(Pageable pageable, Long Id);


}

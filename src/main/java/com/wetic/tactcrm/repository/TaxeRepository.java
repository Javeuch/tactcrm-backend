package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.Facture;
import com.wetic.tactcrm.domain.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeRepository extends JpaRepository<Taxe,Long> {

}

package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.TypeDepense;
import com.wetic.tactcrm.domain.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaiementRepository extends JpaRepository<TypePaiement,Long> {
}

package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.Depense;
import com.wetic.tactcrm.domain.TypeDepense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDepenseRepository extends JpaRepository<TypeDepense,Long> {
}

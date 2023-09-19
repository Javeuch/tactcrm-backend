package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.Devise;
import com.wetic.tactcrm.domain.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviseRepository extends JpaRepository<Devise,Long> {
}

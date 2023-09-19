package com.wetic.tactcrm.service;

import com.wetic.tactcrm.domain.Facture;
import com.wetic.tactcrm.service.dto.FactureDTO;
import com.wetic.tactcrm.service.dto.FactureViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FactureService {

    FactureDTO save(FactureDTO clientDTO);

    Page<FactureDTO> findAll(Pageable pageable);

    Page<FactureDTO> findAllForView(Pageable pageable);
    
    Page<FactureDTO> findByClientId(Pageable pageable, Long id);

    Optional<FactureDTO> findOne(Long id);

    void delete(Long id);

    Optional<FactureViewDTO> findOneForView(Long id);
}

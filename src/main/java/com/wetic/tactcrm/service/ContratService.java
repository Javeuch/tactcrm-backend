package com.wetic.tactcrm.service;

import com.wetic.tactcrm.service.dto.ContratDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContratService {

    ContratDTO save(ContratDTO clientDTO);

    Page<ContratDTO> findAll(Pageable pageable);

    Page<ContratDTO> findByClientId(Pageable pageable, Long id);

    Optional<ContratDTO> findOne(Long id);

    void delete(Long id);
}

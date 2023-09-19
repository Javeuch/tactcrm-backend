package com.wetic.tactcrm.service;

import com.wetic.tactcrm.service.dto.TypeDepenseDTO;
import com.wetic.tactcrm.service.dto.TypePaiementDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TypePaiementService {
    TypePaiementDTO save(TypePaiementDTO clientDTO);

    Page<TypePaiementDTO> findAll(Pageable pageable);

    List<TypePaiementDTO> findAllAsList();

    Optional<TypePaiementDTO> findOne(Long id);

    void delete(Long id);
}

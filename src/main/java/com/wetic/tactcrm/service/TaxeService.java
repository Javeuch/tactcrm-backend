package com.wetic.tactcrm.service;

import com.wetic.tactcrm.service.dto.TaxeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface TaxeService {

    TaxeDTO save(TaxeDTO clientDTO);

    Page<TaxeDTO> findAll(Pageable pageable);

    List<TaxeDTO> findAllAsList();

    Optional<TaxeDTO> findOne(Long id);

    void delete(Long id);

}


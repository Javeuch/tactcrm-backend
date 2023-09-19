package com.wetic.tactcrm.service;

import com.wetic.tactcrm.service.dto.DepenseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DepenseService {

    DepenseDTO save(DepenseDTO clientDTO);


    Page<DepenseDTO> findAll(Pageable pageable);


    Optional<DepenseDTO> findOne(Long id);


    void delete(Long id);
}

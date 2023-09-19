package com.wetic.tactcrm.service;

import com.wetic.tactcrm.service.dto.TypeDepenseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TypeDepenseService {
    TypeDepenseDTO save(TypeDepenseDTO clientDTO);

    Page<TypeDepenseDTO> findAll(Pageable pageable);

    List<TypeDepenseDTO> findAllAsList();

    Optional<TypeDepenseDTO> findOne(Long id);

    void delete(Long id);
}

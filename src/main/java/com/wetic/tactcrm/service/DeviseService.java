package com.wetic.tactcrm.service;

import com.wetic.tactcrm.service.dto.DeviseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DeviseService {

    DeviseDTO save(DeviseDTO clientDTO);

    Page<DeviseDTO> findAll(Pageable pageable);

    List<DeviseDTO> findAllAsList();

    Optional<DeviseDTO> findOne(Long id);

    void delete(Long id);
}

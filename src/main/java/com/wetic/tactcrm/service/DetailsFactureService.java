package com.wetic.tactcrm.service;

import com.wetic.tactcrm.service.dto.DetailsFactureDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DetailsFactureService {

    DetailsFactureDTO save(DetailsFactureDTO detailsFactureDTO);

    Page<DetailsFactureDTO> findAll(Pageable pageable);


    Optional<DetailsFactureDTO> findOne(Long id);


    void delete(Long id);

    List<DetailsFactureDTO> findDetailFactureByFactureId(long factureId);

}

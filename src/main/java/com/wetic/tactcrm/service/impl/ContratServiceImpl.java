package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.Contrat;
import com.wetic.tactcrm.repository.ContratRepository;
import com.wetic.tactcrm.service.ContratService;
import com.wetic.tactcrm.service.dto.ContratDTO;
import com.wetic.tactcrm.service.mapper.ContratMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ContratServiceImpl implements ContratService {

    private final ContratRepository contratRepository;



    private final ContratMapper contratMapper;


    public ContratServiceImpl(ContratRepository contratRepository, ContratMapper contratMapper) {
        this.contratRepository = contratRepository;
        this.contratMapper = contratMapper;
    }

    @Override
    public ContratDTO save(ContratDTO contratDTO) {
        Contrat contrat = contratMapper.toEntity(contratDTO);
        contrat = contratRepository.save(contrat);
        return contratMapper.toDto(contrat);

    }

    @Override
    public Page<ContratDTO> findAll(Pageable pageable) {
        return contratRepository.findAll(pageable)
                .map(contratMapper::toDto);
    }

    @Override
    public Page<ContratDTO> findByClientId(Pageable pageable, Long id) {
        return contratRepository.findByUtilisateurId(pageable, id)
                .map(contratMapper::toDto);
    }
    @Override
    public Optional<ContratDTO> findOne(Long id) {
        return contratRepository.findById(id)
                .map(contratMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        contratRepository.deleteById(id);
    }
}

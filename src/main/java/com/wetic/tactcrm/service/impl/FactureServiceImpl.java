package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.Facture;
import com.wetic.tactcrm.repository.FactureRepository;
import com.wetic.tactcrm.service.FactureService;
import com.wetic.tactcrm.service.dto.FactureDTO;
import com.wetic.tactcrm.service.dto.FactureViewDTO;
import com.wetic.tactcrm.service.mapper.FactureMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FactureServiceImpl implements FactureService {

    private final FactureRepository factureRepository;
    private final FactureMapper factureMapper;

    public FactureServiceImpl(FactureRepository factureRepository, FactureMapper factureMapper) {
        this.factureRepository = factureRepository;
        this.factureMapper = factureMapper;
    }

    @Override
    public FactureDTO save(FactureDTO factureDTO) {
        Facture facture = factureMapper.toEntity(factureDTO);
        facture = factureRepository.save(facture);
        return factureMapper.toDto(facture);
    }

    @Override
    public Page<FactureDTO> findAll(Pageable pageable) {
        return factureRepository.findAll(pageable)
                .map(factureMapper::toDto);
    }

    @Override
    public Page<FactureDTO> findAllForView(Pageable pageable) {
        return factureRepository.findAllForView(pageable)
                .map(factureMapper::toDto);
    }

    @Override
    public Page<FactureDTO> findByClientId(Pageable pageable, Long id) {
        return factureRepository.findByUtilisateurId(pageable, id)
                .map(factureMapper::toDto);
    }

    @Override
    public Optional<FactureDTO> findOne(Long id) {
        return factureRepository.findById(id)
                .map(factureMapper::toDto);
    }

    @Override
    public Optional<FactureViewDTO> findOneForView(Long id) {
        return factureRepository.findOneForViewById(id)
                .map(factureMapper::toFactureViewDto);
    }

    @Override
    public void delete(Long id) {
        factureRepository.deleteById(id);
    }
}

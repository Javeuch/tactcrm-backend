package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.TypePaiement;
import com.wetic.tactcrm.repository.TypePaiementRepository;
import com.wetic.tactcrm.service.TypePaiementService;
import com.wetic.tactcrm.service.dto.TypePaiementDTO;
import com.wetic.tactcrm.service.mapper.TypePaiementMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypePaiementServiceImpl implements TypePaiementService {

    private final TypePaiementRepository typePaiementRepository;
    private final TypePaiementMapper typePaiementMapper;


    public TypePaiementServiceImpl(TypePaiementRepository typePaiementRepository, TypePaiementMapper typePaiementMapper) {
        this.typePaiementRepository = typePaiementRepository;
        this.typePaiementMapper = typePaiementMapper;
    }

    @Override
    public TypePaiementDTO save(TypePaiementDTO typePaiementDTO) {
        TypePaiement typePaiement = typePaiementMapper.toEntity(typePaiementDTO);
        typePaiement = typePaiementRepository.save(typePaiement);
        return typePaiementMapper.toDto(typePaiement);
    }

    @Override
    public Page<TypePaiementDTO> findAll(Pageable pageable) {
        return typePaiementRepository.findAll(pageable)
                .map(typePaiementMapper::toDto);
    }

    @Override
    public List<TypePaiementDTO> findAllAsList() {
        return typePaiementRepository.findAll()
                .stream()
                .map(typePaiementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TypePaiementDTO> findOne(Long id) {
        return typePaiementRepository.findById(id)
                .map(typePaiementMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        typePaiementRepository.deleteById(id);
    }
}

package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.Taxe;
import com.wetic.tactcrm.repository.TaxeRepository;
import com.wetic.tactcrm.service.TaxeService;
import com.wetic.tactcrm.service.dto.TaxeDTO;
import com.wetic.tactcrm.service.mapper.TaxeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaxeServiceImpl implements TaxeService {

    private final TaxeRepository taxeRepository;
    private final TaxeMapper taxeMapper;

    public TaxeServiceImpl(TaxeRepository taxeRepository, TaxeMapper taxeMapper) {
        this.taxeRepository = taxeRepository;
        this.taxeMapper = taxeMapper;
    }

    @Override
    public TaxeDTO save(TaxeDTO taxeDTO) {
        Taxe taxe = taxeMapper.toEntity(taxeDTO);
        taxe = taxeRepository.save(taxe);
        return taxeMapper.toDto(taxe);

    }

    @Override
    public Page<TaxeDTO> findAll(Pageable pageable) {
        return taxeRepository.findAll(pageable)
                .map(taxeMapper::toDto);
    }

    @Override
    public List<TaxeDTO> findAllAsList() {
        return taxeRepository.findAll()
                .stream()
                .map(taxeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TaxeDTO> findOne(Long id) {
        return taxeRepository.findById(id)
                .map(taxeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        taxeRepository.deleteById(id);
    }
}

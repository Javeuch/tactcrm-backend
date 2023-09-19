package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.Depense;
import com.wetic.tactcrm.repository.DepenseRepository;
import com.wetic.tactcrm.service.DepenseService;
import com.wetic.tactcrm.service.dto.DepenseDTO;
import com.wetic.tactcrm.service.mapper.DepenseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DepenseServiceImpl implements DepenseService {


    private final DepenseRepository depenseRepository;
    private final DepenseMapper depenseMapper;

    public DepenseServiceImpl(DepenseRepository depenseRepository, DepenseMapper depenseMapper) {
        this.depenseRepository = depenseRepository;
        this.depenseMapper = depenseMapper;
    }

    @Override
    public DepenseDTO save(DepenseDTO depenseDTO) {
        Depense depense = depenseMapper.toEntity(depenseDTO);
        depense = depenseRepository.save(depense);
        return depenseMapper.toDto(depense);

    }

    @Override
    public Page<DepenseDTO> findAll(Pageable pageable) {
        return depenseRepository.findAll(pageable)
                .map(depenseMapper::toDto);
    }

    @Override
    public Optional<DepenseDTO> findOne(Long id) {
        return depenseRepository.findById(id)
                .map(depenseMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        depenseRepository.deleteById(id);
    }
}

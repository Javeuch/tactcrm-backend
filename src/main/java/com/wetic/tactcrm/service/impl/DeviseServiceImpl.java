package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.Devise;
import com.wetic.tactcrm.repository.DeviseRepository;
import com.wetic.tactcrm.service.DeviseService;
import com.wetic.tactcrm.service.dto.DeviseDTO;
import com.wetic.tactcrm.service.mapper.DeviseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviseServiceImpl implements DeviseService {

    private final DeviseRepository deviseRepository;
    private final DeviseMapper deviseMapper;

    public DeviseServiceImpl(DeviseRepository deviseRepository, DeviseMapper deviseMapper) {
        this.deviseRepository = deviseRepository;
        this.deviseMapper = deviseMapper;
    }

    @Override
    public DeviseDTO save(DeviseDTO deviseDTO) {
        Devise devise = deviseMapper.toEntity(deviseDTO);
        devise = deviseRepository.save(devise);
        return deviseMapper.toDto(devise);
    }

    @Override
    public Page<DeviseDTO> findAll(Pageable pageable) {
        return deviseRepository.findAll(pageable)
                .map(deviseMapper::toDto);

    }

    @Override
    public List<DeviseDTO> findAllAsList() {
        return deviseRepository.findAll()
                .stream()
                .map(deviseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DeviseDTO> findOne(Long id) {
        return deviseRepository.findById(id)
                .map(deviseMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        deviseRepository.deleteById(id);
    }
}

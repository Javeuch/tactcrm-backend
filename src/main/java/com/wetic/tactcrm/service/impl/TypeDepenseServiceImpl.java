package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.TypeDepense;
import com.wetic.tactcrm.repository.TypeDepenseRepository;
import com.wetic.tactcrm.service.TypeDepenseService;
import com.wetic.tactcrm.service.dto.TypeDepenseDTO;
import com.wetic.tactcrm.service.mapper.TypeDepenseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeDepenseServiceImpl implements TypeDepenseService {

    private final TypeDepenseRepository typeDepenseRepository;
    private final TypeDepenseMapper typeDepenseMapper;

    public TypeDepenseServiceImpl(TypeDepenseRepository typeDepenseRepository, TypeDepenseMapper typeDepenseMapper) {
        this.typeDepenseRepository = typeDepenseRepository;
        this.typeDepenseMapper = typeDepenseMapper;
    }

    @Override
    public TypeDepenseDTO save(TypeDepenseDTO typeDepenseDTO) {
        TypeDepense typeDepense = typeDepenseMapper.toEntity(typeDepenseDTO);
        typeDepense = typeDepenseRepository.save(typeDepense);
        return typeDepenseMapper.toDto(typeDepense);
    }

    @Override
    public Page<TypeDepenseDTO> findAll(Pageable pageable) {
        return typeDepenseRepository.findAll(pageable)
                .map(typeDepenseMapper::toDto);
    }
    @Override
    public List<TypeDepenseDTO> findAllAsList() {
        return typeDepenseRepository.findAll()
                .stream()
                .map(typeDepenseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TypeDepenseDTO> findOne(Long id) {
        return typeDepenseRepository.findById(id)
                .map(typeDepenseMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        typeDepenseRepository.deleteById(id);
    }
}

package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.DetailsFacture;
import com.wetic.tactcrm.repository.DetailsFactureRepository;
import com.wetic.tactcrm.service.DetailsFactureService;
import com.wetic.tactcrm.service.dto.DetailsFactureDTO;
import com.wetic.tactcrm.service.mapper.DetailsFactureMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetailsFactureServiceImpl implements DetailsFactureService {

    private final DetailsFactureRepository detailsFactureRepository;
    private final DetailsFactureMapper detailsFactureMapper;

    public DetailsFactureServiceImpl(DetailsFactureRepository detailsFactureRepository, DetailsFactureMapper detailsFactureMapper) {
        this.detailsFactureRepository = detailsFactureRepository;
        this.detailsFactureMapper = detailsFactureMapper;
    }

    @Override
    public DetailsFactureDTO save(DetailsFactureDTO detailsFactureDTO) {
        DetailsFacture detailsFacture = detailsFactureMapper.toEntity(detailsFactureDTO);
        detailsFacture = detailsFactureRepository.save(detailsFacture);
        return detailsFactureMapper.toDto(detailsFacture);
    }

    @Override
    public Page<DetailsFactureDTO> findAll(Pageable pageable) {
        return detailsFactureRepository.findAll(pageable)
                .map(detailsFactureMapper::toDto);
    }

    @Override
    public Optional<DetailsFactureDTO> findOne(Long id) {
        return detailsFactureRepository.findById(id)
                .map(detailsFactureMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        detailsFactureRepository.deleteById(id);
    }

    @Override
    public List<DetailsFactureDTO> findDetailFactureByFactureId(long factureId) {
        return detailsFactureRepository.findDetailsFactureByFactureId(factureId)
                .stream()
                .map(detailsFactureMapper::toDto)
                .collect(Collectors.toList());
    }

}

package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.Adresse;
import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.repository.AdresseRepository;
import com.wetic.tactcrm.repository.UtilisateurRepository;
import com.wetic.tactcrm.security.SecurityUtils;
import com.wetic.tactcrm.service.AdresseService;
import com.wetic.tactcrm.service.UtilisateurService;
import com.wetic.tactcrm.service.dto.AdresseDTO;
import com.wetic.tactcrm.service.dto.UtilisateurDTO;
import com.wetic.tactcrm.service.mapper.AdresseMapper;
import com.wetic.tactcrm.service.mapper.UtilisateurMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;

    private final AdresseMapper adresseMapper;

    public AdresseServiceImpl(AdresseRepository adresseRepository, AdresseMapper adresseMapper) {
        this.adresseRepository = adresseRepository;
        this.adresseMapper = adresseMapper;
    }

    @Override
    public AdresseDTO save(AdresseDTO adresseDTO) {
        Adresse adresse = adresseMapper.toEntity(adresseDTO);
        adresse = adresseRepository.save(adresse);
        return adresseMapper.toDto(adresse);
    }

    @Override
    public Page<AdresseDTO> findAll(Pageable pageable) {
        return adresseRepository.findAll(pageable)
                .map(adresseMapper::toDto);
    }

    @Override
    public Optional<AdresseDTO> findOne(Long id) {
        return adresseRepository.findById(id)
                .map(adresseMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        adresseRepository.deleteById(id);
    }

}

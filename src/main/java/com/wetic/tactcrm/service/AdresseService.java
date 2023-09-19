package com.wetic.tactcrm.service;

import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.service.dto.AdresseDTO;
import com.wetic.tactcrm.service.dto.UtilisateurDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface AdresseService{

    AdresseDTO save(AdresseDTO adresseDTO);

    Page<AdresseDTO> findAll(Pageable pageable);

    Optional<AdresseDTO> findOne(Long id);

    void delete(Long id);


}

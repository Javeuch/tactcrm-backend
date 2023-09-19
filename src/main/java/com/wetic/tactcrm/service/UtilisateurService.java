package com.wetic.tactcrm.service;

import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.service.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService extends UserDetailsService {

    Page<UtilisateurDTO> findAll(Pageable pageable);
    List<UtilisateurDTO> findAllAsList();
    Optional<Utilisateur> findByLogin(String login);
    Optional<UtilisateurDTO> findOne(Long id);
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    Optional<Utilisateur> getCurrentUserLogin();
    
    UtilisateurDTO save(UtilisateurDTO clientDTO);
    UtilisateurDTO save(CreateOrEditUtilisateurDTO clientDTO);

    StatsDTO getStats();

    void delete(Long id);

    LineChartOutput getLineChartData();

    PieChartOutput getPieChartOutput();
}

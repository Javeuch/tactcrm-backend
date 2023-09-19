package com.wetic.tactcrm.service.impl;

import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.repository.DepenseRepository;
import com.wetic.tactcrm.repository.DetailsFactureRepository;
import com.wetic.tactcrm.repository.FactureRepository;
import com.wetic.tactcrm.repository.UtilisateurRepository;
import com.wetic.tactcrm.security.SecurityUtils;
import com.wetic.tactcrm.service.UtilisateurService;
import com.wetic.tactcrm.service.dto.*;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final DetailsFactureRepository detailsFactureRepository;
    private final DepenseRepository depenseRepository;
    private final FactureRepository factureRepository;

    private final UtilisateurMapper utilisateurMapper;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, DetailsFactureRepository detailsFactureRepository, DepenseRepository depenseRepository, FactureRepository factureRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.detailsFactureRepository = detailsFactureRepository;
        this.depenseRepository = depenseRepository;
        this.factureRepository = factureRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public UtilisateurDTO save(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);
        utilisateur.setPassword(passwordEncoder().encode(utilisateurDTO.getPassword()));
        try{

        utilisateur = utilisateurRepository.save(utilisateur);
        }catch(Exception e){
            Object exception = e;
        }
        return utilisateurMapper.toDto(utilisateur);
    }

    @Override
    public UtilisateurDTO save(CreateOrEditUtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);
        utilisateur.setPassword(passwordEncoder().encode(utilisateurDTO.getPassword()));
        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDto(utilisateur);
    }


    @Override
    public Page<UtilisateurDTO> findAll(Pageable pageable) {
        return utilisateurRepository.findAll(pageable)
                .map(utilisateurMapper::toDto);
    }

    @Override
    public List<UtilisateurDTO> findAllAsList() {
        return utilisateurRepository.findAll()
                .stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UtilisateurDTO> findOne(Long id) {
        return utilisateurRepository.findById(id)
                .map(utilisateurMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateur =  utilisateurRepository.findByLogin(login);
        return new User(utilisateur.get().getUsername(), utilisateur.get().getPassword(), AuthorityUtils.NO_AUTHORITIES);
    }

    @Override
    public Optional<Utilisateur>  findByLogin(String login) {
        Optional<Utilisateur> utilisateur =  utilisateurRepository.findByLogin(login);
        return utilisateur;
    }

//    public Optional<Utilisateur> getUtilisateurWithLogin() {
//        Optional<Utilisateur> result = SecurityUtils.getCurrentUserLogin()
//                .flatMap(utilisateurRepository::findOneByLogin);
//        return result;
//    }

    public Optional<Utilisateur> getCurrentUserLogin() {
        Optional<Utilisateur> result = SecurityUtils.getCurrentUserLogin()
                .flatMap(utilisateurRepository::findByLogin);
        return result;
    }

    public StatsDTO getStats() {
        StatsDTO stats = new StatsDTO();
        stats.setCountClient(utilisateurRepository.count());
        stats.setCountProduitVendue(detailsFactureRepository.sumProduitQuantity());
        stats.setSumDepense(depenseRepository.SumAll());
        stats.setSumProfit(detailsFactureRepository.SumDetailsFacture());
        return stats;
    }

    public LineChartOutput getLineChartData(){
        LineChartOutput lineChartOutput = new LineChartOutput();
        lineChartOutput.setSumProfitByMonth(detailsFactureRepository.SumProfitByMonth());
        lineChartOutput.setSumDepenseByMonth(depenseRepository.SumDepenseByMonth());
        return lineChartOutput;
    }

    public PieChartOutput getPieChartOutput(){
        PieChartOutput pieChartOutput = new PieChartOutput();
        pieChartOutput.setFactureByTypePaiement(factureRepository.factureByTypePaiement());
        pieChartOutput.setDepenseByTypeDepense(depenseRepository.depenseByTypeDepense());
        return pieChartOutput;
    }
}

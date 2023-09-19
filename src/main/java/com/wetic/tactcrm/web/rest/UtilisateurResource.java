package com.wetic.tactcrm.web.rest;


import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.repository.UtilisateurRepository;
import com.wetic.tactcrm.service.AdresseService;
import com.wetic.tactcrm.service.UtilisateurService;
import com.wetic.tactcrm.service.dto.*;
import com.wetic.tactcrm.service.mapper.UtilisateurMapper;
import com.wetic.tactcrm.web.util.RestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UtilisateurResource {

    private static class AccountResourceException extends RuntimeException {
        private AccountResourceException(String message) {
            super(message);
        }
    }

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurService utilisateurService;
    private final UtilisateurMapper utilisateurMapper;
    private final AdresseService adresseService;
    private final Logger log  = LoggerFactory.getLogger(TypeDepenseResource.class);




    public UtilisateurResource(UtilisateurRepository utilisateurRepository,
                               UtilisateurService utilisateurService,
                               UtilisateurMapper utilisateurMapper,
                               AdresseService adresseService
    ) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurService = utilisateurService;
        this.utilisateurMapper = utilisateurMapper;
        this.adresseService = adresseService;
    }

    @GetMapping("/utilisateurs")
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateur(Pageable pageable,
                                                              @RequestParam MultiValueMap<String,
                                                                      String> queryParams, UriComponentsBuilder uriBuilder){
        Page<UtilisateurDTO> page = utilisateurService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateur(@PathVariable Long id) {
        Optional<UtilisateurDTO> utilisateurDTO = utilisateurService.findOne(id);

        return RestUtils.wrapOrNotFound(utilisateurDTO, null);
    }


//    @PostMapping("/utilisateurs")
//    public ResponseEntity<UtilisateurDTO> createUtilisateur(@Valid @RequestBody UtilisateurDTO utilisateurDTO) throws URISyntaxException {
//        UtilisateurDTO result  = utilisateurService.save(utilisateurDTO);
//
//        return ResponseEntity.created(new URI("/api/utilisateurs" + result.getId()))
//                .body(result);
//    }



    // utilisateur must have utilisateur id
    @PostMapping("/utilisateurs")
    public ResponseEntity<UtilisateurDTO> createUtilisateur(@Valid @RequestBody CreateOrEditUtilisateurDTO utilisateurDTO) throws URISyntaxException {
        if(utilisateurDTO.getAdresse() !=null){
            AdresseDTO savedAdress = adresseService.save(utilisateurDTO.getAdresse());
            utilisateurDTO.setAdresseId(savedAdress.getId());
        }

        UtilisateurDTO result  = utilisateurService.save(utilisateurDTO);

        return ResponseEntity.created(new URI("/api/utilisateurs" + result.getId()))
                .body(result);
    }

    @PutMapping("/utilisateurs")
    public ResponseEntity<UtilisateurDTO> updateUtilisateur(@Valid @RequestBody UtilisateurDTO utilisateurDTO) throws URISyntaxException {
        if (utilisateurDTO.getId()==null){
            return null;
        }
        UtilisateurDTO result = utilisateurService.save(utilisateurDTO);
        return ResponseEntity.created(new URI("/api/utilisateurs" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/utilisateurs/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) throws URISyntaxException{

        utilisateurService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        return request.getRemoteUser();
    }

    @GetMapping("/account")
    public UtilisateurDTO getAccount() {
        log.info("started /account");
        UtilisateurDTO result = utilisateurService.getCurrentUserLogin()
                .map(utilisateurMapper::toDto)
                .orElseThrow(()->new AccountResourceException("user not found"));
        return result;
    }

    @GetMapping("/utilisateurs/all")
    public ResponseEntity<List<UtilisateurDTO>> getAllTaxe(){
        List<UtilisateurDTO> utilisateursList = utilisateurService.findAllAsList();
        return ResponseEntity.ok().body(utilisateursList);
    }

    @GetMapping("/utilisateurs/utilisateur/stats")
    public ResponseEntity<StatsDTO> getStats() {
        log.debug("REST request to get statistiques for dashboard admin");
        return ResponseEntity.ok(utilisateurService.getStats());
    }


    @GetMapping("/utilisateurs/dashboard/line-chart")
    public ResponseEntity<LineChartOutput>  getLineChartData() {
        return ResponseEntity.ok(utilisateurService.getLineChartData());
    }

    @GetMapping("/utilisateurs/dashboard/pie-charts")
    public ResponseEntity<PieChartOutput>  getPieChartData() {
        return ResponseEntity.ok(utilisateurService.getPieChartOutput());
    }
}
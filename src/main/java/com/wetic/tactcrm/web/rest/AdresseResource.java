package com.wetic.tactcrm.web.rest;


import com.wetic.tactcrm.repository.UtilisateurRepository;
import com.wetic.tactcrm.service.AdresseService;
import com.wetic.tactcrm.service.UtilisateurService;
import com.wetic.tactcrm.service.dto.AdresseDTO;
import com.wetic.tactcrm.service.dto.CreateOrEditUtilisateurDTO;
import com.wetic.tactcrm.service.dto.UtilisateurDTO;
import com.wetic.tactcrm.service.mapper.AdresseMapper;
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
public class AdresseResource {

    private final AdresseService adresseService;
    private final AdresseMapper adresseMapper;




    public AdresseResource(AdresseService adresseService,AdresseMapper adresseMapper
    ) {
        this.adresseService = adresseService;
        this.adresseMapper = adresseMapper;
    }

    @GetMapping("/adresses")
    public ResponseEntity<List<AdresseDTO>> getAllAdresse(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<AdresseDTO> page = adresseService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/adresses/{id}")
    public ResponseEntity<AdresseDTO> getAdresse(@PathVariable Long id) {
        Optional<AdresseDTO> typeDepenseDTO = adresseService.findOne(id);
        return RestUtils.wrapOrNotFound(typeDepenseDTO, null);
    }

    @PostMapping("/adresses")
    public ResponseEntity<AdresseDTO> createAdresse(@Valid @RequestBody AdresseDTO deviseDTO) throws URISyntaxException {
        AdresseDTO result  = adresseService.save(deviseDTO);
        return ResponseEntity.created(new URI("/api/adresses" + result.getId()))
                .body(result);
    }

    @PutMapping("/adresses")
    public ResponseEntity<AdresseDTO> updateAdresse(@Valid @RequestBody AdresseDTO deviseDTO) throws URISyntaxException {
        if (deviseDTO.getId()==null){
            return null;
        }
        AdresseDTO result = adresseService.save(deviseDTO);
        return ResponseEntity.created(new URI("/api/adresses" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/adresses/{id}")
    public ResponseEntity<Void> deleteAdresse(@PathVariable Long id) throws URISyntaxException{
        adresseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

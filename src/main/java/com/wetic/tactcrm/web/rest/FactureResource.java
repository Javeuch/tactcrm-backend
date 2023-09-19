package com.wetic.tactcrm.web.rest;

import com.wetic.tactcrm.repository.FactureRepository;
import com.wetic.tactcrm.service.FactureService;
import com.wetic.tactcrm.service.dto.FactureDTO;
import com.wetic.tactcrm.service.dto.FactureViewDTO;
import com.wetic.tactcrm.web.util.RestUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FactureResource {

    private final FactureRepository factureRepository;
    private final FactureService factureService;

    public FactureResource(FactureRepository factureRepository, FactureService factureService) {
        this.factureRepository = factureRepository;
        this.factureService = factureService;
    }

    @GetMapping("/factures")
    public ResponseEntity<List<FactureDTO>> getAllFacture(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<FactureDTO> page = factureService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/factures/client/{id}")
    public ResponseEntity<List<FactureDTO>> getAllFacturesByClientId(Pageable pageable,@PathVariable Long id, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<FactureDTO> page = factureService.findByClientId(pageable, id);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/factures/{id}")
    public ResponseEntity<FactureDTO> getTypeDepense(@PathVariable Long id) {
        Optional<FactureDTO> typeDepenseDTO = factureService.findOne(id);
        return RestUtils.wrapOrNotFound(typeDepenseDTO, null);
    }

    @GetMapping("/factures/{id}/view")
    public ResponseEntity<FactureViewDTO> getFactureForView(@PathVariable Long id) {
        Optional<FactureViewDTO> factureDTO = factureService.findOneForView(id);
        return RestUtils.wrapOrNotFound(factureDTO, null);
    }

    @PostMapping("/factures")
    public ResponseEntity<FactureDTO> createFacture(@Valid @RequestBody FactureDTO factureDTO) throws URISyntaxException {
        FactureDTO result  = factureService.save(factureDTO);
        return ResponseEntity.created(new URI("/api/factures" + result.getId()))
                .body(result);
    }

    @PutMapping("/factures")
    public ResponseEntity<FactureDTO> updateFacture(@Valid @RequestBody FactureDTO factureDTO) throws URISyntaxException {
        if (factureDTO.getId()==null){
            return null;
        }
        FactureDTO result = factureService.save(factureDTO);
        return ResponseEntity.created(new URI("/api/factures" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/factures/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) throws URISyntaxException{

        factureService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/factures/view")
    public ResponseEntity<List<FactureDTO>> getAllFactureForView(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<FactureDTO> page = factureService.findAllForView(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

}

package com.wetic.tactcrm.web.rest;


import com.wetic.tactcrm.repository.TaxeRepository;
import com.wetic.tactcrm.service.TaxeService;
import com.wetic.tactcrm.service.dto.TaxeDTO;
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
public class TaxeResource {

    private final TaxeRepository taxeRepository;
    private final TaxeService taxeService;

    public TaxeResource(TaxeRepository taxeRepository, TaxeService taxeService) {
        this.taxeRepository = taxeRepository;
        this.taxeService = taxeService;
    }

    @GetMapping("/taxes")
    public ResponseEntity<List<TaxeDTO>> getAllTaxe(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<TaxeDTO> page = taxeService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/taxes/{id}")
    public ResponseEntity<TaxeDTO> getTypeDepense(@PathVariable Long id) {
        Optional<TaxeDTO> typeDepenseDTO = taxeService.findOne(id);
        return RestUtils.wrapOrNotFound(typeDepenseDTO, null);
    }

    @PostMapping("/taxes")
    public ResponseEntity<TaxeDTO> createTaxe(@Valid @RequestBody TaxeDTO taxeDTO) throws URISyntaxException {
        TaxeDTO result  = taxeService.save(taxeDTO);
        return ResponseEntity.created(new URI("/api/taxes" + result.getId()))
                .body(result);
    }

    @PutMapping("/taxes")
    public ResponseEntity<TaxeDTO> updateTaxe(@Valid @RequestBody TaxeDTO taxeDTO) throws URISyntaxException {
        if (taxeDTO.getId()==null){
            return null;
        }
        TaxeDTO result = taxeService.save(taxeDTO);
        return ResponseEntity.created(new URI("/api/taxes" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/taxes/{id}")
    public ResponseEntity<Void> deleteTaxe(@PathVariable Long id) throws URISyntaxException{

        taxeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/taxes/all")
    public ResponseEntity<List<TaxeDTO>> getAllTaxe(){
        List<TaxeDTO> listTaxes = taxeService.findAllAsList();
        return ResponseEntity.ok().body(listTaxes);
    }
}

package com.wetic.tactcrm.web.rest;

import com.wetic.tactcrm.repository.ContratRepository;
import com.wetic.tactcrm.service.ContratService;
import com.wetic.tactcrm.service.dto.ContratDTO;
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
public class ContratResource {

    private final ContratRepository contratRepository;
    private final ContratService contratService;


    public ContratResource(ContratRepository contratRepository, ContratService contratService) {
        this.contratRepository = contratRepository;
        this.contratService = contratService;
    }

    @GetMapping("/contrats")
    public ResponseEntity<List<ContratDTO>> getAllContrat(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<ContratDTO> page = contratService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/contrats/client/{id}")
    public ResponseEntity<List<ContratDTO>> getAllFacturesByClientId(Pageable pageable,@PathVariable Long id, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<ContratDTO> page = contratService.findByClientId(pageable, id);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    @GetMapping("/contrats/{id}")
    public ResponseEntity<ContratDTO> getTypeDepense(@PathVariable Long id) {
        Optional<ContratDTO> typeDepenseDTO = contratService.findOne(id);
        return RestUtils.wrapOrNotFound(typeDepenseDTO, null);
    }

    @PostMapping("/contrats")
    public ResponseEntity<ContratDTO> createContrat(@Valid @RequestBody ContratDTO deviseDTO) throws URISyntaxException {
        ContratDTO result  = contratService.save(deviseDTO);
        return ResponseEntity.created(new URI("/api/contrats" + result.getId()))
                .body(result);
    }

    @PutMapping("/contrats")
    public ResponseEntity<ContratDTO> updateContrat(@Valid @RequestBody ContratDTO deviseDTO) throws URISyntaxException {
        if (deviseDTO.getId()==null){
            return null;
        }
        ContratDTO result = contratService.save(deviseDTO);
        return ResponseEntity.created(new URI("/api/contrats" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/contrats/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) throws URISyntaxException{

        contratService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

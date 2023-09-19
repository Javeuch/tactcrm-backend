package com.wetic.tactcrm.web.rest;


import com.wetic.tactcrm.repository.DeviseRepository;
import com.wetic.tactcrm.service.DeviseService;
import com.wetic.tactcrm.service.dto.DeviseDTO;
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
public class DeviseResource {

    private final DeviseRepository deviseRepository;
    private final DeviseService deviseService;

    public DeviseResource(DeviseRepository deviseRepository, DeviseService deviseService) {
        this.deviseRepository = deviseRepository;
        this.deviseService = deviseService;
    }

    @GetMapping("/devises")
    public ResponseEntity<List<DeviseDTO>> getAllDevise(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<DeviseDTO> page = deviseService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/devises/{id}")
    public ResponseEntity<DeviseDTO> getTypeDepense(@PathVariable Long id) {
        Optional<DeviseDTO> typeDepenseDTO = deviseService.findOne(id);
        return RestUtils.wrapOrNotFound(typeDepenseDTO, null);
    }

    @PostMapping("/devises")
    public ResponseEntity<DeviseDTO> createDevise(@Valid @RequestBody DeviseDTO deviseDTO) throws URISyntaxException {
        DeviseDTO result  = deviseService.save(deviseDTO);
        return ResponseEntity.created(new URI("/api/devises" + result.getId()))
                .body(result);
    }

    @PutMapping("/devises")
    public ResponseEntity<DeviseDTO> updateDevise(@Valid @RequestBody DeviseDTO deviseDTO) throws URISyntaxException {
        if (deviseDTO.getId()==null){
            return null;
        }
        DeviseDTO result = deviseService.save(deviseDTO);
        return ResponseEntity.created(new URI("/api/devises" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/devises/{id}")
    public ResponseEntity<Void> deleteDevise(@PathVariable Long id) throws URISyntaxException{

        deviseService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/devises/all")
    public ResponseEntity<List<DeviseDTO>> getAllTaxe(){
        List<DeviseDTO> listDevise = deviseService.findAllAsList();
        return ResponseEntity.ok().body(listDevise);
    }

}

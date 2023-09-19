package com.wetic.tactcrm.web.rest;


import com.wetic.tactcrm.repository.TypeDepenseRepository;
import com.wetic.tactcrm.service.TypeDepenseService;
import com.wetic.tactcrm.service.dto.TypeDepenseDTO;
import com.wetic.tactcrm.web.util.RestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.net.URISyntaxException;
import java.net.URI;


/*
TODO:
- add alert system to informe front with the request response
- add exception handling
 */
@RestController
@RequestMapping("/api")
public class TypeDepenseResource {

    private final TypeDepenseService  typeDepenseService;
    private final Logger log  = LoggerFactory.getLogger(TypeDepenseResource.class);

    public TypeDepenseResource(TypeDepenseRepository typeDepenseRepository, TypeDepenseService typeDepenseService) {
        this.typeDepenseService = typeDepenseService;
    }


    @GetMapping("/type-depenses")
    public ResponseEntity<List<TypeDepenseDTO>> getAllTypeDepenses(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        Page<TypeDepenseDTO> page = typeDepenseService.findAll(pageable);
        HttpHeaders headers = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/type-depenses/{id}")
    public ResponseEntity<TypeDepenseDTO> getTypeDepense(@PathVariable Long id) {
        Optional<TypeDepenseDTO> typeDepenseDTO = typeDepenseService.findOne(id);
        return RestUtils.wrapOrNotFound(typeDepenseDTO, null);
    }

    @PostMapping("/type-depenses")
    public ResponseEntity<TypeDepenseDTO> createTypeDepense(@Valid @RequestBody TypeDepenseDTO typeDepenseDTO)
            throws URISyntaxException {
        log.info("Rest request to save typeDepense : {}",typeDepenseDTO);
        if (typeDepenseDTO.getId() != null) {
            ResponseEntity.badRequest().build();
        }
        TypeDepenseDTO result = typeDepenseService.save(typeDepenseDTO);
        return ResponseEntity.created(new URI("/api/type-depenses/" + result.getId()))
                .body(result);
    }

    @PutMapping("/type-depenses")
    public ResponseEntity<TypeDepenseDTO> updateTypeDepense(@Valid @RequestBody TypeDepenseDTO typeDepenseDTO) throws URISyntaxException {
        log.info("Rest request to edit typeDepense : {}",typeDepenseDTO);
        if (typeDepenseDTO.getId() == null) {
            return null;
        }
        TypeDepenseDTO result = typeDepenseService.save(typeDepenseDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/type-depenses/{id}")
    public ResponseEntity<Void> deleteTypeDepense(@PathVariable Long id) {
        typeDepenseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type-depenses/all")
    public ResponseEntity<List<TypeDepenseDTO>> getAllTaxe(){
        List<TypeDepenseDTO> listTypeDepense = typeDepenseService.findAllAsList();
        return ResponseEntity.ok().body(listTypeDepense);
    }

}

package com.wetic.tactcrm.web.rest;


import com.wetic.tactcrm.repository.TypePaiementRepository;
import com.wetic.tactcrm.service.TypePaiementService;
import com.wetic.tactcrm.service.dto.TypeDepenseDTO;
import com.wetic.tactcrm.service.dto.TypePaiementDTO;
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
public class TypePaiementResource {

    private final TypePaiementRepository typePaiementRepository;
    ;
    private final TypePaiementService typePaiementService;

    public TypePaiementResource(TypePaiementRepository typePaiementRepository, TypePaiementService typePaiementService) {
        this.typePaiementRepository = typePaiementRepository;
        this.typePaiementService = typePaiementService;
    }

    @GetMapping("/type-paiements")
    public ResponseEntity<List<TypePaiementDTO>> getAllTypePaiement(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<TypePaiementDTO> page = typePaiementService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/type-paiements/{id}")
    public ResponseEntity<TypePaiementDTO> getTypeDepense(@PathVariable Long id) {
        Optional<TypePaiementDTO> typeDepenseDTO = typePaiementService.findOne(id);
        return RestUtils.wrapOrNotFound(typeDepenseDTO, null);
    }

    @PostMapping("/type-paiements")
    public ResponseEntity<TypePaiementDTO> createTypePaiement(@Valid @RequestBody TypePaiementDTO typePaiementDTO) throws URISyntaxException {
        TypePaiementDTO result  = typePaiementService.save(typePaiementDTO);
        return ResponseEntity.created(new URI("/api/type-paiements" + result.getId()))
                .body(result);
    }

    @PutMapping("/type-paiements")
    public ResponseEntity<TypePaiementDTO> updateTypePaiement(@Valid @RequestBody TypePaiementDTO typePaiementDTO) throws URISyntaxException {
        if (typePaiementDTO.getId()==null){
            return null;
        }
        TypePaiementDTO result = typePaiementService.save(typePaiementDTO);
        return ResponseEntity.created(new URI("/api/type-paiements" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/type-paiements/{id}")
    public ResponseEntity<Void> deleteTypePaiement(@PathVariable Long id) throws URISyntaxException{
        try{
        typePaiementService.delete(id);
        return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/type-paiements/all")
    public ResponseEntity<List<TypePaiementDTO>> getAllTaxe(){
        List<TypePaiementDTO> typePaiementsList = typePaiementService.findAllAsList();
        return ResponseEntity.ok().body(typePaiementsList);
    }

}

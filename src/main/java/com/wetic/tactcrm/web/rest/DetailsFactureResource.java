package com.wetic.tactcrm.web.rest;

import com.wetic.tactcrm.repository.DetailsFactureRepository;
import com.wetic.tactcrm.service.DetailsFactureService;
import com.wetic.tactcrm.service.dto.DetailsFactureDTO;
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

@RestController
@RequestMapping("/api")
public class DetailsFactureResource {

    private final DetailsFactureRepository detailsFactureRepository;
    private final DetailsFactureService detailsFactureService;

    public DetailsFactureResource(DetailsFactureRepository detailsFactureRepository, DetailsFactureService detailsFactureService) {
        this.detailsFactureRepository = detailsFactureRepository;
        this.detailsFactureService = detailsFactureService;
    }

    @GetMapping("/details-factures")
    public ResponseEntity<List<DetailsFactureDTO>> getAllDetailsFacture(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder){
        Page<DetailsFactureDTO> page = detailsFactureService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @PostMapping("/details-factures")
    public ResponseEntity<DetailsFactureDTO> createDetailsFacture(@Valid @RequestBody DetailsFactureDTO detailsFactureDTO) throws URISyntaxException {
        DetailsFactureDTO result  = detailsFactureService.save(detailsFactureDTO);
        return ResponseEntity.created(new URI("/api/details-factures" + result.getId()))
                .body(result);
    }

    @PutMapping("/details-factures")
    public ResponseEntity<DetailsFactureDTO> updateDetailsFacture(@Valid @RequestBody DetailsFactureDTO detailsFactureDTO) throws URISyntaxException {
        if (detailsFactureDTO.getId()==null){
            return null;
        }
        DetailsFactureDTO result = detailsFactureService.save(detailsFactureDTO);
        return ResponseEntity.created(new URI("/api/details-factures" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/details-factures/{id}")
    public ResponseEntity<Void> deleteDetailsFacture(@PathVariable Long id) throws URISyntaxException{

        detailsFactureService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/details-factures/facture/{id}")
    public ResponseEntity<List<DetailsFactureDTO>> getAllDetailsFacturesByFactureId(@PathVariable Long id) {
        List<DetailsFactureDTO> detailsFactureList = detailsFactureService.findDetailFactureByFactureId(id);
        return ResponseEntity.ok().body(detailsFactureList);
    }


}

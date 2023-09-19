package com.wetic.tactcrm.web.rest;


import com.wetic.tactcrm.repository.DepenseRepository;
import com.wetic.tactcrm.service.DepenseService;
import com.wetic.tactcrm.service.dto.DepenseDTO;
import com.wetic.tactcrm.web.util.RestUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
// import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
import java.net.URISyntaxException;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class DepenseResource {

    private final DepenseService depenseService;

    public DepenseResource(DepenseService depenseService) {
        this.depenseService = depenseService;
    }

    @GetMapping("/depenses")
    public ResponseEntity<List<DepenseDTO>> getAllDepense(Pageable pageable, @RequestParam MultiValueMap<String,
            String> queryParams, UriComponentsBuilder uriBuilder){

        Page<DepenseDTO> page = depenseService.findAll(pageable);
        HttpHeaders headers  = RestUtils.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        headers.add("Access-Control-Expose-Headers", "X-Total-Count, Link");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/depenses/{id}")
    public ResponseEntity<DepenseDTO> getTypeDepense(@PathVariable Long id) {
        Optional<DepenseDTO> typeDepenseDTO = depenseService.findOne(id);
        return RestUtils.wrapOrNotFound(typeDepenseDTO, null);
    }

    @PostMapping("/depenses")
    public ResponseEntity<DepenseDTO> createDepense(@Valid @RequestBody DepenseDTO depenseDTO) throws URISyntaxException{
       DepenseDTO result  = depenseService.save(depenseDTO);
       return ResponseEntity.created(new URI("/api/depenses" + result.getId()))
               .body(result);
    }

    @PutMapping("/depenses")
    public ResponseEntity<DepenseDTO> updateDepense(@Valid @RequestBody DepenseDTO depenseDTO) throws URISyntaxException {
        if (depenseDTO.getId()==null){
           return null;
        }
        DepenseDTO result = depenseService.save(depenseDTO);
        return ResponseEntity.created(new URI("/api/depenses" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/depenses/{id}")
    public ResponseEntity<Void> deleteDepense(@PathVariable Long id) throws URISyntaxException{

        depenseService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

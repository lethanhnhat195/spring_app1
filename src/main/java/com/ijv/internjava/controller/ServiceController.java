package com.ijv.internjava.controller;


import com.ijv.internjava.model.dto.ServiceDto;
import com.ijv.internjava.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor= @__(@Autowired))
@RequestMapping("/services")
public class ServiceController {
    private ServiceService serviceService;

    @GetMapping
    public List<ServiceDto> findAll() {
        return serviceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDto> detail(
            @PathVariable(name = "id") Long id
    ) {
        ServiceDto serviceDtoResponse = serviceService.detail(id);
        return ResponseEntity.ok().body(serviceDtoResponse);
    }

    @PostMapping
    public ResponseEntity<ServiceDto> create(
            @RequestBody ServiceDto serviceDtoRequest
    ) {
        ServiceDto serviceDtoResponse = serviceService.create(serviceDtoRequest);
        return new ResponseEntity<>(serviceDtoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDto> edit(
            @PathVariable Long id,
            @RequestBody ServiceDto serviceDtoRequest
    ) {
        ServiceDto serviceDtoResponse = serviceService.edit(serviceDtoRequest, id);
        return ResponseEntity.ok().body(serviceDtoResponse);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable(name = "id") Long id
    ) {
        serviceService.delete(id);
    }

}

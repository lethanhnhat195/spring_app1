package com.ijv.internjava.controller;

import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.model.dto.CustomerDto;
import com.ijv.internjava.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.model.dto.CustomerDto;
import com.ijv.internjava.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /*Get all*/

    @GetMapping
    public ResponseEntity<ApiResponseDto> findAll() {
        return ResponseEntity.ok().body(ApiResponseDto.builder()
                .code("customerService.findAll()")
                .message("Get all customer")
                .data(customerService.findAll())
                .status("HttpStatus.CREATED")
                .build());
    }

    /*Get customer detail*/
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> detail(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(ApiResponseDto.builder()
                .code("customerService.detail(id)")
                .message("Get customer detail by id")
                .data(customerService.detail(id))
                .status("HttpStatus.CREATED")
                .build());
    }

    /*Add customer*/
    @PostMapping("/add")
    public ResponseEntity<ApiResponseDto> add(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok().body(ApiResponseDto.builder()
                .code("HttpStatus.CREATED")
                .message("Add new customer")
                .data(customerService.add(customerDto))
                .status("HttpStatus.CREATED")
                .build());
    }

    /*Update customer*/
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponseDto> update(@PathVariable("id") long customerId, @RequestBody CustomerDto customerDto) {

        return ResponseEntity.ok().body(ApiResponseDto.builder()
                .code("")
                .message("Update customer")
                .data(customerService.update(customerId,customerDto))
                .status("HttpStatus.CREATED")
                .build());
    }

    /*Delete customer*/
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") long customerId) {
        customerService.delete(customerId);
    }
}

package com.ijv.internjava.controller;

import com.ijv.internjava.model.dto.CustomerDto;
import com.ijv.internjava.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    /*Get all*/
    @GetMapping("/list")
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        List<CustomerDto> customers = iCustomerService.getCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /*Add customer*/
    @PostMapping("/add")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = iCustomerService.addCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    /*Update customer*/
    @PutMapping("/update")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") long customerId, @RequestBody CustomerDto customerDto) {
        customerDto.setId(customerId);
        CustomerDto updatedCustomer = iCustomerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    /*Delete customer*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long customerId) {
        iCustomerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer successfully deleted!", HttpStatus.OK);
    }

    /**/

}

package com.ijv.internjava.mapper;

import com.ijv.internjava.model.dto.CustomerDto;
import com.ijv.internjava.model.entity.Customer;

public class CustomerMapper {
    private static CustomerMapper INSTANCE;

    public static CustomerMapper getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new CustomerMapper();
        }
        return INSTANCE;
    }

    public Customer toEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setTotalMoney(customerDto.getTotalMoney());
        return customer;
    }

    public CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setCustomerName(customer.getCustomerName());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setAddress(customer.getAddress());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        customerDto.setTotalMoney(customer.getTotalMoney());
        return customerDto;
    }
}

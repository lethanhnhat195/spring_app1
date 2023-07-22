package com.ijv.internjava.service.impl;

import com.ijv.internjava.mapper.CustomerMapper;
import com.ijv.internjava.model.dto.CustomerDto;
import com.ijv.internjava.model.entity.Customer;
import com.ijv.internjava.repository.CustomerRepository;
import com.ijv.internjava.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("CustomerService")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(customer -> CustomerMapper.getInstance().toDto(customer))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto detail(long id) {
        Customer customer = customerRepository.findById(id).get();
        return CustomerMapper.getInstance().toDto(customer);
    }

    @Override
    public CustomerDto add(CustomerDto customerDto) {
        Customer newCus = new Customer();
        newCus.setId(customerDto.getId());
        newCus.setCustomerName(customerDto.getCustomerName());
        newCus.setPhoneNumber(customerDto.getPhoneNumber());
        newCus.setAddress(customerDto.getAddress());
        newCus.setDateOfBirth(customerDto.getDateOfBirth());
        newCus.setTotalMoney(customerDto.getTotalMoney());
        Customer cusAdded = customerRepository.save(newCus);
        return CustomerMapper.getInstance().toDto(cusAdded);
    }

    @Override
    public CustomerDto update(long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).get();
        customer.setId(customerDto.getId());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setTotalMoney(customerDto.getTotalMoney());
        Customer cusUpdated = customerRepository.save(customer);
        return CustomerMapper.getInstance().toDto(cusUpdated);
    }

    @Override
    public void delete(long id) {
        if (id>0) {
            Customer customer = customerRepository.getById(id);
            if (customer != null) {
                customerRepository.delete(customer);
            }
        }
    }
}
package com.ijv.internjava.service;

import com.ijv.internjava.model.dto.CustomerDto;
import com.ijv.internjava.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDto getCustomerDetail(long id) {
        return customerRepository.getById(id);
    }

    @Override
    public CustomerDto addCustomer(CustomerDto customerdto) {
        if (customerdto != null) {
            return customerRepository.save(customerdto);
        }
        return null;
    }

    @Override
    public CustomerDto updateCustomer(long id, CustomerDto customerdto) {
        if (customerdto != null) {
            CustomerDto customerDto1 = customerRepository.getById(id);
            if (customerDto1 != null) {
                customerDto1.setCustomerName(customerdto.getCustomerName());
                customerDto1.setPhoneNumber(customerdto.getPhoneNumber());
                customerDto1.setAddress(customerdto.getAddress());
                customerDto1.setDateOfBirth(customerdto.getDateOfBirth());
                customerDto1.setTotalMoney(customerdto.getTotalMoney());
                customerDto1.setCreatedBy(customerdto.getCreatedBy());
                customerDto1.setCreatedOn(customerdto.getCreatedOn());
                customerDto1.setUpdatedBy(customerdto.getUpdatedBy());
                customerDto1.setUpdatedOn(customerdto.getUpdatedOn());
                customerDto1.setIsDeleted(customerdto.getIsDeleted());

                return customerRepository.save(customerDto1);
            }
        }
        return null;
    }

    @Override
    public void deleteCustomer(long id) {
        if (id>=1) {
            CustomerDto customerDto = customerRepository.getById(id);
            if (customerDto != null) {
                customerRepository.delete(customerDto);
            }
        }
    }
}

package com.ijv.internjava.service;

import com.ijv.internjava.model.dto.CustomerDto;

import java.util.List;

public interface ICustomerService {
    /*1. Show list customer*/
     List<CustomerDto> getCustomer();
    /*2. Show customer detail*/
     CustomerDto getCustomerDetail(long id);
    /*3. Add customer*/
     CustomerDto addCustomer(CustomerDto customerdto);
    /*4. Edit customer*/
     CustomerDto updateCustomer(long id, CustomerDto customerdto);
    /*5. Delete customer*/
     void deleteCustomer(long id);
    /*6. Show booking history of customer*/

}

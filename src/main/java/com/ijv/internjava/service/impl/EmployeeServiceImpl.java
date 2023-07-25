package com.ijv.internjava.service.impl;


import com.ijv.internjava.exception.ResourceNotFoundException;
import com.ijv.internjava.model.entity.Employees;
import com.ijv.internjava.model.entity.WorkShift;
import com.ijv.internjava.repository.EmployeeRepository;
import com.ijv.internjava.service.EmployeeService;
import com.ijv.internjava.service.ExcelUploadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employees> getAllEmployee() {
        List<Employees> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public List<Employees> searchEmployees(String query) {
        List<Employees> employees = employeeRepository.searchEmployees(query);
        return employees;
    }

    @Override
    public Employees createEmployee(Employees employee) {
        Optional<Employees> employeeByEmail = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employees getEmployeeById(Long id) {
        Employees employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        return employee;
    }

    @Override
    public Employees updateEmployee(Long id, Employees employeeDetail) {
        Optional<Employees> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()){
            Employees employee = optionalEmployee.get();

            employee.setName(employeeDetail.getName());
            employee.setGender(employeeDetail.getGender());
            employee.setBirthday(employeeDetail.getBirthday());
            employee.setAddress(employeeDetail.getAddress());
            employee.setPhone(employeeDetail.getPhone());
            employee.setEmail(employeeDetail.getEmail());
            employee.setUserName(employeeDetail.getUserName());
            employee.setPassword(employeeDetail.getPassword());
            employee.setImage(employeeDetail.getImage());
            employee.setWorkShiftId(new WorkShift(employeeDetail.getId()));

            Employees updateEmployee = employeeRepository.save(employee);
            return updateEmployee;
        }else {
            throw new ResourceNotFoundException("Employee not exist with id : " + id);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        employeeRepository.deleteById(id);
    }

    @Override
    public Employees resetPassword(Long id, Employees employeeDetail) {
        final String passwordDefault = "A123456@";
        Employees employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));

        employee.setPassword("passwordDefault");
        Employees resetEmployee = employeeRepository.save(employee);
        return resetEmployee;
    }

    public void saveEmployeesToDatabase(MultipartFile file) {
        if(ExcelUploadService.isValueExcelFile(file)){
            try {
                List<Employees> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.employeeRepository.saveAll(employees);
            }catch (IOException e) {
                throw new IllegalStateException("the file is not a valid excel file");
            }
        }
    }
}
package com.ijv.internjava.service.impl;

<<<<<<< HEAD

<<<<<<< HEAD
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import com.ijv.internjava.exception.ResourceNotFoundException;
import com.ijv.internjava.model.entity.Employee;
import com.ijv.internjava.model.entity.WorkShift;
import com.ijv.internjava.repository.EmployeeRepository;

import com.ijv.internjava.service.ExcelUploadService;

import com.ijv.internjava.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository EmployeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = EmployeeRepository.findAll();
        return employees;
    }

    @Override
    public List<Employee> searchEmployees(String query) {
        List<Employee> employees = EmployeeRepository.searchEmployees(query);
        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
        Optional<Employee> employeeByEmail = employeeRepository.findEmployeeByEmail(employee.getEmail());
<<<<<<< HEAD
        if (employeeByEmail.isPresent()) {
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
=======
        Optional<Employee> employeeByEmail = EmployeeRepository.findEmployeeByEmail(employee.getEmail());
>>>>>>> 56d4993 (fix conflict from main branch)
        if(employeeByEmail.isPresent()) {
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
        Optional<Employee> employeeByEmail = EmployeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeByEmail.isPresent()) {
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
        if(employeeByEmail.isPresent()) {
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
            throw new IllegalStateException("email taken");
        }
        return EmployeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = EmployeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetail) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            employee.setName(employeeDetail.getName());
            employee.setGender(employeeDetail.getGender());
            employee.setBirthday(employeeDetail.getBirthday());
            employee.setAddress(employeeDetail.getAddress());
            employee.setPhone(employeeDetail.getPhone());
            employee.setEmail(employeeDetail.getEmail());
            employee.setUserName(employeeDetail.getUserName());
            employee.setPassword(employeeDetail.getPassword());
            employee.setImage(employeeDetail.getImage());
            employee.setWorkShift(new WorkShift(employeeDetail.getId()));

            Employee updateEmployee = employeeRepository.save(employee);
            return updateEmployee;
        } else {
            throw new ResourceNotFoundException("Employee not exist with id : " + id);
        }
=======
       Optional<Employee> optionalEmployee = employeeRepository.findById(id);
<<<<<<< HEAD
<<<<<<< HEAD
=======
       Optional<Employee> optionalEmployee = EmployeeRepository.findById(id);
>>>>>>> 56d4993 (fix conflict from main branch)

        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
=======
       Optional<Employee> optionalEmployee = EmployeeRepository.findById(id);

       if (optionalEmployee.isPresent()){
           Employee employee = optionalEmployee.get();
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======

       if (optionalEmployee.isPresent()){
           Employee employee = optionalEmployee.get();
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
=======
       Optional<Employee> optionalEmployee = EmployeeRepository.findById(id);
>>>>>>> 56d4993 (fix conflict from main branch)

        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
>>>>>>> b3c47dc (update dependency maven)

           employee.setName(employeeDetail.getName());
           employee.setGender(employeeDetail.getGender());
           employee.setBirthday(employeeDetail.getBirthday());
           employee.setAddress(employeeDetail.getAddress());
           employee.setPhone(employeeDetail.getPhone());
           employee.setEmail(employeeDetail.getEmail());
<<<<<<< HEAD
<<<<<<< HEAD
           employee.setUsername(employeeDetail.getUsername());
=======
           employee.setUserName(employeeDetail.getUserName());
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
           employee.setUsername(employeeDetail.getUsername());
>>>>>>> b3c47dc (update dependency maven)
           employee.setPassword(employeeDetail.getPassword());
           employee.setImage(employeeDetail.getImage());
           employee.setWorkShift(new WorkShift(employeeDetail.getId()));

<<<<<<< HEAD
<<<<<<< HEAD
           Employee updateEmployee = EmployeeRepository.save(employee);
=======
           Employee updateEmployee = employeeRepository.save(employee);
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
           Employee updateEmployee = EmployeeRepository.save(employee);
>>>>>>> b3c47dc (update dependency maven)
           return updateEmployee;
       }else {
           throw new ResourceNotFoundException("Employee not exist with id : " + id);
       }
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
>>>>>>> 81be34c (Fix conflict on branch customer manager)

    @Override
    public void deleteEmployee(Long id) {
        EmployeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        EmployeeRepository.deleteById(id);
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    @Override
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
    @Override
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
=======
    @Override
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
    public Employee resetPassword(Long id, Employee employeeDetail) {
        final String passwordDefault = "A123456@";
        Employee employee = EmployeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));

        employee.setPassword("passwordDefault");
        Employee resetEmployee = EmployeeRepository.save(employee);
        return resetEmployee;
    }

    public void saveEmployeesToDatabase(MultipartFile file) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
        if (ExcelUploadService.isValueExcelFile(file)) {
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.employeeRepository.saveAll(employees);
            } catch (IOException e) {
=======
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
        if(ExcelUploadService.isValueExcelFile(file)){
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.EmployeeRepository.saveAll(employees);
            }catch (IOException e) {
<<<<<<< HEAD
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
        if(ExcelUploadService.isValueExcelFile(file)){
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.EmployeeRepository.saveAll(employees);
            }catch (IOException e) {
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
                throw new IllegalStateException("the file is not a valid excel file");
            }
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> b3c47dc (update dependency maven)
  
    @Override
    public Optional<Employee> findByUsername(String username) {
        return EmployeeRepository.findByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return EmployeeRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return EmployeeRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return EmployeeRepository.existsByPhone(phone);
    }

    @Override
    public void save(Employee employee) {
        EmployeeRepository.save(employee);
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 56d4993 (fix conflict from main branch)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> 56d4993 (fix conflict from main branch)
>>>>>>> b3c47dc (update dependency maven)
}

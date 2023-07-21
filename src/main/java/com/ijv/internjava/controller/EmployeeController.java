package com.ijv.internjava.controller;



import com.ijv.internjava.model.entity.Employee;
import com.ijv.internjava.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/employee")
public class EmployeeController {

    @Autowired
<<<<<<< HEAD
    private EmployeeService EmployeeService;
=======
    private EmployeeService employeeService;
>>>>>>> fb13f8d (create repository, service and controller for employee management)

    //get all employees
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployees() {
<<<<<<< HEAD
        List<Employee> employees = EmployeeService.getAllEmployee();
=======
        List<Employee> employees = employeeService.getAllEmployee();
>>>>>>> fb13f8d (create repository, service and controller for employee management)
        return ResponseEntity.ok(employees);
    }
    //search employee
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam("query") String query) {
<<<<<<< HEAD
        return ResponseEntity.ok(EmployeeService.searchEmployees(query));
=======
        return ResponseEntity.ok(employeeService.searchEmployees(query));
>>>>>>> fb13f8d (create repository, service and controller for employee management)
    }

    // create employee rest api
    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
<<<<<<< HEAD
            Employee createEmployee = EmployeeService.createEmployee(employee);
=======
            Employee createEmployee = employeeService.createEmployee(employee);
>>>>>>> fb13f8d (create repository, service and controller for employee management)
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createEmployee.getEmail()).toUri();
            return ResponseEntity.created(location).body(createEmployee);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"An error occurred while creating the employee",e);
        }
    }
    // get employee
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
<<<<<<< HEAD
        Employee employee = EmployeeService.getEmployeeById(id);
=======
        Employee employee = employeeService.getEmployeeById(id);
>>>>>>> fb13f8d (create repository, service and controller for employee management)
        return ResponseEntity.ok(employee);
    }
    //update employee rest api
    @PutMapping("update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails) {

<<<<<<< HEAD
        Employee updateEmployee = EmployeeService.updateEmployee(id, employeeDetails);
=======
        Employee updateEmployee = employeeService.updateEmployee(id, employeeDetails);
>>>>>>> fb13f8d (create repository, service and controller for employee management)
        return ResponseEntity.ok(updateEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

<<<<<<< HEAD
        EmployeeService.deleteEmployee(id);
=======
        employeeService.deleteEmployee(id);
>>>>>>> fb13f8d (create repository, service and controller for employee management)
        return ResponseEntity.noContent().build();
    }

    // reset password to default
    @PutMapping("/reset_password/{id}")
    public  ResponseEntity<Employee> resetPassword(@PathVariable Long id, @RequestBody Employee employeeDetails) {
<<<<<<< HEAD
        Employee resetEmployee = EmployeeService.resetPassword(id,employeeDetails);
=======
        Employee resetEmployee = employeeService.resetPassword(id,employeeDetails);
>>>>>>> fb13f8d (create repository, service and controller for employee management)
        return ResponseEntity.ok(resetEmployee);
    }

    //get template import file excel
    @PostMapping("/upload-file-data")
    public ResponseEntity<?> uploadEmployeesData(@RequestParam("file")MultipartFile file) {
<<<<<<< HEAD
        EmployeeService.saveEmployeesToDatabase(file);
=======
        employeeService.saveEmployeesToDatabase(file);
>>>>>>> fb13f8d (create repository, service and controller for employee management)
        return ResponseEntity.ok(Map.of("Message","Employees data uploaded and saved to database successfully"));
    }

}


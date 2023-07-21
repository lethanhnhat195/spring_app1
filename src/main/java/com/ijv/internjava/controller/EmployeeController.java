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
    private EmployeeService EmployeeService;

    //get all employees
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = EmployeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }
    //search employee
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam("query") String query) {
        return ResponseEntity.ok(EmployeeService.searchEmployees(query));
    }

    // create employee rest api
    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee createEmployee = EmployeeService.createEmployee(employee);
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
        Employee employee = EmployeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
    //update employee rest api
    @PutMapping("update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails) {

        Employee updateEmployee = EmployeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(updateEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

        EmployeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // reset password to default
    @PutMapping("/reset_password/{id}")
    public  ResponseEntity<Employee> resetPassword(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee resetEmployee = EmployeeService.resetPassword(id,employeeDetails);
        return ResponseEntity.ok(resetEmployee);
    }

    //get template import file excel
    @PostMapping("/upload-file-data")
    public ResponseEntity<?> uploadEmployeesData(@RequestParam("file")MultipartFile file) {
        EmployeeService.saveEmployeesToDatabase(file);
        return ResponseEntity.ok(Map.of("Message","Employees data uploaded and saved to database successfully"));
    }

}


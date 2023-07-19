package com.ijv.internjava.controller;

import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.model.entity.Employee;
import com.ijv.internjava.model.entity.EmployeeService;
import com.ijv.internjava.sercurity.jwt.JwtService;
import com.ijv.internjava.sercurity.payload.request.AuthenticationRequest;
import com.ijv.internjava.sercurity.payload.request.EmployeeUpdateRequest;
import com.ijv.internjava.sercurity.payload.request.PasswordUpdateRequest;
import com.ijv.internjava.sercurity.userdetail.AuthenticationService;
import com.ijv.internjava.sercurity.payload.request.RegisterRequest;
import com.ijv.internjava.service.IEmployeeService;
import com.ijv.internjava.utils.CommonConstants;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class SecurityController {

    @Autowired
    private IEmployeeService employeeService;
    private final AuthenticationService service;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto> signup(@Validated @RequestBody RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(service.isError(request, bindingResult));
        }
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto> login(@RequestBody AuthenticationRequest request,HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(service.authenticate(request,httpServletRequest));
    }

    @PutMapping("/update-user-info")
    public ResponseEntity<ApiResponseDto> updateUserInfo(@Validated @RequestBody EmployeeUpdateRequest request
            ,BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        String username = jwtService.getUsernameFromToke(httpServletRequest.getHeader("Authorization").substring(7));
        Employee employee = employeeService.findByUsername(username).orElse(null);
        if(employee == null){
            return  ResponseEntity.badRequest().body(
                    ApiResponseDto
                            .builder()
                            .message("User not found")
                            .build()
            );
        }
        request.setId(employee.getId());
        return ResponseEntity.ok().body(service.updateEmployee(request,employee));
    }

    @PutMapping("/change-password")
    public ResponseEntity<ApiResponseDto> changeEmployeePassword(@Validated @RequestBody PasswordUpdateRequest request, BindingResult bindingResult
            , HttpServletRequest httpServletRequest) {
        String username = jwtService.getUsernameFromToke(httpServletRequest.getHeader("Authorization").substring(7));
        Employee employee = employeeService.findByUsername(username).orElse(null);
        if(employee == null){
            return  ResponseEntity.badRequest().body(
                    ApiResponseDto
                            .builder()
                            .message("User not found")
                            .build()
            );
        }
        return ResponseEntity.ok().body(service.changePassword(request));
    }
}

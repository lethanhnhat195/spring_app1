package com.ijv.internjava.controller;

import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.sercurity.payload.request.EmployeeUpdateRequest;
import com.ijv.internjava.sercurity.payload.request.PasswordUpdateRequest;
import com.ijv.internjava.sercurity.userdetail.AuthenticationService;
import com.ijv.internjava.sercurity.payload.request.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class SecurityController {

    private final AuthenticationService service;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto> signup(@Validated @RequestBody RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(service.isError(request, bindingResult));
        }
        return ResponseEntity.ok(service.register(request));
    }

    @PutMapping("/update-user-info")
    public ResponseEntity<ApiResponseDto> updateUserInfo(@Validated @RequestBody EmployeeUpdateRequest request
            ,BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        new EmployeeUpdateRequest().validate(request,bindingResult);
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(
                    ApiResponseDto
                            .builder()
                            .message("No valid")
                            .data(bindingResult.getAllErrors())
                            .build());
        }
        String auth = httpServletRequest.getHeader("Authorization");
        if(auth == null || !auth.startsWith("Bearer ")){
            return  ResponseEntity.badRequest().body(
                    ApiResponseDto
                            .builder()
                            .message("User not found")
                            .build()
            );
        }
        return ResponseEntity.ok().body(service.updateEmployee(request,auth));
    }

    @PutMapping("/change-password")
    public ResponseEntity<ApiResponseDto> changeEmployeePassword(@Validated @RequestBody PasswordUpdateRequest request, BindingResult bindingResult
          , HttpServletRequest httpServletRequest) {
        new PasswordUpdateRequest().validate(request,bindingResult);
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(
                    ApiResponseDto
                            .builder()
                            .message("No valid")
                            .data(bindingResult.getAllErrors())
                            .build());
        }
        String auth = httpServletRequest.getHeader("Authorization");
        if(auth == null || !auth.startsWith("Bearer ")){
            return  ResponseEntity.badRequest().body(
                    ApiResponseDto
                            .builder()
                            .message("User not found")
                            .build()
            );
        }
        return ResponseEntity.ok().body(service.changePassword(request,auth));
    }
}

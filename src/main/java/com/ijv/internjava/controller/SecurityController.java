package com.ijv.internjava.controller;

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
public class SecurityController extends BaseController{

    private final AuthenticationService service;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Validated @RequestBody RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return failed("User sign up no valid",bindingResult.getAllErrors().toArray());
        }
        return success("Sign up success",service.register(request),null);
    }

    @PutMapping("/update-user-info")
    public ResponseEntity<?> updateUserInfo(@Validated @RequestBody EmployeeUpdateRequest request
            ,BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        new EmployeeUpdateRequest().validate(request,bindingResult);
        if(bindingResult.hasErrors()) {
            return failed("User sign up no valid",bindingResult.getAllErrors().toArray());
        }
        String auth = httpServletRequest.getHeader("Authorization");
        if(auth == null || !auth.startsWith("Bearer ")){
            return failed("User not found",bindingResult.getAllErrors().toArray());
        }
        return success("Update success",service.updateEmployee(request,auth),null);
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changeEmployeePassword(@Validated @RequestBody PasswordUpdateRequest request, BindingResult bindingResult
          , HttpServletRequest httpServletRequest) {
        new PasswordUpdateRequest().validate(request,bindingResult);
        if(bindingResult.hasErrors()){
            return failed("Password no valid",bindingResult.getAllErrors().toArray());
        }
        String auth = httpServletRequest.getHeader("Authorization");
        if(auth == null || !auth.startsWith("Bearer ")){
            return failed("User not found",bindingResult.getAllErrors().toArray());
        }
        return success("Change password success",service.changePassword(request,auth),null);
    }
}

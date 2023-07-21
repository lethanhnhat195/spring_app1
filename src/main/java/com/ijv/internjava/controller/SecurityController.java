package com.ijv.internjava.controller;

import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.sercurity.jwt.JwtService;
import com.ijv.internjava.sercurity.payload.request.AuthenticationRequest;
import com.ijv.internjava.sercurity.payload.request.EmployeeUpdateRequest;
import com.ijv.internjava.sercurity.payload.request.PasswordUpdateRequest;
import com.ijv.internjava.sercurity.userdetail.AuthenticationService;
import com.ijv.internjava.sercurity.payload.request.RegisterRequest;
import com.ijv.internjava.utils.CommonConstants;
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
    private JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto> signup(@Validated @RequestBody RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(service.isError(request, bindingResult));
        }
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PutMapping("/update-user-info")
    public ResponseEntity<ApiResponseDto> updateUserInfo(@Validated @RequestBody EmployeeUpdateRequest request) {
        return ResponseEntity.ok(ApiResponseDto.builder().build());
    }

    @PutMapping("/change-password")
    public ResponseEntity<ApiResponseDto> changeEmployeePassword(@Validated @RequestBody PasswordUpdateRequest request, BindingResult bindingResult
            , HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization").substring(7);
        String username = jwtService.extractUsername(token);
        request.setUsername(username);
        new PasswordUpdateRequest().validate(request, bindingResult);
        if (bindingResult.hasErrors()) {
            ResponseEntity.badRequest().body(ApiResponseDto.builder()
                    .status(CommonConstants.ApiStatus.STATUS_OK)
                    .data(bindingResult.getAllErrors())
                    .message("Change password fail")
                    .build());
        }
        return ResponseEntity.ok().body(service.changePassword(request));
    }
}

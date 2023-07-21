package com.ijv.internjava.sercurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ijv.internjava.model.dto.ApiResponseDto;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.ijv.internjava.model.entity.Employee;
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
=======
import com.ijv.internjava.model.entity.Employee;
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
<<<<<<< HEAD
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
>>>>>>> b3c47dc (update dependency maven)
import com.ijv.internjava.sercurity.jwt.JwtService;
import com.ijv.internjava.sercurity.payload.request.AuthenticationRequest;
import com.ijv.internjava.sercurity.payload.response.AuthenticationResponse;
import com.ijv.internjava.sercurity.payload.response.EmployeeResponse;
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
import com.ijv.internjava.utils.CommonConstants;
import com.ijv.internjava.utils.MessageUtils;
import jakarta.servlet.FilterChain;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.ijv.internjava.utils.CommonConstants;
import com.ijv.internjava.utils.MessageUtils;
import jakarta.servlet.FilterChain;
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import com.ijv.internjava.service.IEmployeeService;
import com.ijv.internjava.utils.CommonConstants;
import com.ijv.internjava.utils.MessageUtils;
import jakarta.servlet.FilterChain;
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
<<<<<<< HEAD
=======
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
=======
import org.springframework.stereotype.Component;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
<<<<<<< HEAD
=======
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)

import java.io.IOException;
import java.util.stream.Collectors;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
=======
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
<<<<<<< HEAD
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
>>>>>>> b3c47dc (update dependency maven)
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    AuthenticationManager authenticationManager;
    @Autowired
    private MessageUtils messageUtils;
    ObjectMapper objectMapper;
    @Autowired
    private JwtService jwtService;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        implementBean(request);
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
    @Autowired
    private IEmployeeService employeeService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)
        String requestData = "";
        try {
            requestData = request.getReader().lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
        String username;
        String password;
        AuthenticationRequest authenticationRequest;
=======
        String username = null;
        String password = null;
        AuthenticationRequest authenticationRequest = null;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
<<<<<<< HEAD
=======
        String username;
        String password;
        AuthenticationRequest authenticationRequest;
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)
        try {
            authenticationRequest = new Gson().fromJson(requestData, AuthenticationRequest.class);
            username = authenticationRequest.getUsername();
            password = authenticationRequest.getPassword();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authenticationManager.authenticate(authToken);
        return auth;
=======
        String currentUsername = username;
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authToken);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
<<<<<<< HEAD
=======
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authenticationManager.authenticate(authToken);
        return auth;
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
        implementBean(request);
        String token = jwtService.generateAccessToken(request, (EmployeeDetails) authResult.getPrincipal());
        EmployeeResponse employeeResponse = new EmployeeResponse();
        BeanUtils.copyProperties(authResult.getPrincipal(),employeeResponse);
                AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
        String token = jwtService.generateAccessToken(request, (EmployeeDetails) authResult.getPrincipal());
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Employee employee = employeeService.findByUsername(jwtService.getUsernameFromToke(token)).get();
        BeanUtils.copyProperties(employee, employeeResponse);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)
                .token(token)
                .employeeResponse(employeeResponse)
                .typeOfToken("Bearer")
                .build();
        ApiResponseDto apiResponseDto = ApiResponseDto.builder().code(CommonConstants.MessageSuccess.SC007)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                .message(null).data(authenticationResponse)
=======
                .message(messageUtils.getMessage(CommonConstants.MessageSuccess.SC007, null)).data(authenticationResponse)
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
                .message(null).data(authenticationResponse)
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
                .message(null).data(authenticationResponse)
=======
                .message(messageUtils.getMessage(CommonConstants.MessageSuccess.SC007, null)).data(authenticationResponse)
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
<<<<<<< HEAD
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
>>>>>>> b3c47dc (update dependency maven)
                .status(CommonConstants.ApiStatus.STATUS_OK).build();
        try {
            response.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
            response.setContentType("application/json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
        implementBean(request);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ApiResponseDto apiResponseDto = ApiResponseDto.builder().code(CommonConstants.MessageError.ER017)
                .data(null)
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ApiResponseDto apiResponseDto = ApiResponseDto.builder().code(CommonConstants.MessageError.ER017)
                .message(messageUtils.getMessage(CommonConstants.MessageError.ERROR_AUTHENTICATE, null)).data(null)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3c47dc (update dependency maven)
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)
                .status(CommonConstants.ApiStatus.STATUS_ERROR).build();
        try {
            response.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
            response.setContentType("application/json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
    private void implementBean(HttpServletRequest request) {
        if ( objectMapper == null || jwtService == null || messageUtils == null) {
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils
                    .getWebApplicationContext(servletContext);
            assert webApplicationContext != null;
            objectMapper = webApplicationContext.getBean(ObjectMapper.class);
            jwtService = webApplicationContext.getBean(JwtService.class);
            messageUtils = webApplicationContext.getBean(MessageUtils.class);
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
=======
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
<<<<<<< HEAD
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
>>>>>>> b3c47dc (update dependency maven)
}

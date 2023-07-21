package com.ijv.internjava.sercurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ijv.internjava.model.dto.ApiResponseDto;
<<<<<<< HEAD
=======
import com.ijv.internjava.model.entity.Employee;
>>>>>>> a3e137a (create update employee and change password)
import com.ijv.internjava.sercurity.jwt.JwtService;
import com.ijv.internjava.sercurity.payload.request.AuthenticationRequest;
import com.ijv.internjava.sercurity.payload.response.AuthenticationResponse;
import com.ijv.internjava.sercurity.payload.response.EmployeeResponse;
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;
import com.ijv.internjava.service.IEmployeeService;
import com.ijv.internjava.utils.CommonConstants;
import com.ijv.internjava.utils.MessageUtils;
import jakarta.servlet.FilterChain;
<<<<<<< HEAD
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
=======
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
>>>>>>> a3e137a (create update employee and change password)
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
<<<<<<< HEAD
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
=======
import org.springframework.stereotype.Component;
>>>>>>> a3e137a (create update employee and change password)

import java.io.IOException;
import java.util.stream.Collectors;

<<<<<<< HEAD
=======
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
>>>>>>> a3e137a (create update employee and change password)
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    AuthenticationManager authenticationManager;
    @Autowired
    private MessageUtils messageUtils;
    ObjectMapper objectMapper;
    @Autowired
    private JwtService jwtService;
<<<<<<< HEAD

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        implementBean(request);
=======
    @Autowired
    private IEmployeeService employeeService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
>>>>>>> a3e137a (create update employee and change password)
        String requestData = "";
        try {
            requestData = request.getReader().lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        String username;
        String password;
        AuthenticationRequest authenticationRequest;
=======
        String username = null;
        String password = null;
        AuthenticationRequest authenticationRequest = null;
>>>>>>> a3e137a (create update employee and change password)
        try {
            authenticationRequest = new Gson().fromJson(requestData, AuthenticationRequest.class);
            username = authenticationRequest.getUsername();
            password = authenticationRequest.getPassword();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
<<<<<<< HEAD
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authenticationManager.authenticate(authToken);
        return auth;
=======
        String currentUsername = username;
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authToken);
>>>>>>> a3e137a (create update employee and change password)
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
<<<<<<< HEAD
        implementBean(request);
        String token = jwtService.generateAccessToken(request, (EmployeeDetails) authResult.getPrincipal());
        EmployeeResponse employeeResponse = new EmployeeResponse();
        BeanUtils.copyProperties(authResult.getPrincipal(),employeeResponse);
                AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
=======
        String token = jwtService.generateAccessToken(request, (EmployeeDetails) authResult.getPrincipal());
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Employee employee = employeeService.findByUsername(jwtService.getUsernameFromToke(token)).get();
        BeanUtils.copyProperties(employee, employeeResponse);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
>>>>>>> a3e137a (create update employee and change password)
                .token(token)
                .employeeResponse(employeeResponse)
                .typeOfToken("Bearer")
                .build();
        ApiResponseDto apiResponseDto = ApiResponseDto.builder().code(CommonConstants.MessageSuccess.SC007)
<<<<<<< HEAD
                .message(null).data(authenticationResponse)
=======
                .message(messageUtils.getMessage(CommonConstants.MessageSuccess.SC007, null)).data(authenticationResponse)
>>>>>>> a3e137a (create update employee and change password)
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
        implementBean(request);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ApiResponseDto apiResponseDto = ApiResponseDto.builder().code(CommonConstants.MessageError.ER017)
                .data(null)
=======
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ApiResponseDto apiResponseDto = ApiResponseDto.builder().code(CommonConstants.MessageError.ER017)
                .message(messageUtils.getMessage(CommonConstants.MessageError.ERROR_AUTHENTICATE, null)).data(null)
>>>>>>> a3e137a (create update employee and change password)
                .status(CommonConstants.ApiStatus.STATUS_ERROR).build();
        try {
            response.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
            response.setContentType("application/json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
<<<<<<< HEAD
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
=======
>>>>>>> a3e137a (create update employee and change password)
}

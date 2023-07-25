package com.ijv.internjava.sercurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.sercurity.jwt.JwtService;
import com.ijv.internjava.sercurity.payload.request.AuthenticationRequest;
import com.ijv.internjava.sercurity.payload.response.AuthenticationResponse;
import com.ijv.internjava.sercurity.payload.response.EmployeeResponse;
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;
import com.ijv.internjava.utils.CommonConstants;
import com.ijv.internjava.utils.MessageUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.ijv.internjava.service.IEmployeeService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.stream.Collectors;

@PropertySource("classpath:application.properties")
@RequiredArgsConstructor

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    AuthenticationManager authenticationManager;
    @Autowired
    private MessageUtils messageUtils;
    ObjectMapper objectMapper;
    private JwtService jwtService;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        implementBean(request);
        @Autowired
        private IEmployeeService employeeService;

        @Override
        public Authentication attemptAuthentication (HttpServletRequest request, HttpServletResponse response) throws
        AuthenticationException {
            String requestData = "";
            try {
                requestData = request.getReader().lines().collect(Collectors.joining());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String username = null;
            String password = null;
            AuthenticationRequest authenticationRequest = null;
            try {
                authenticationRequest = new Gson().fromJson(requestData, AuthenticationRequest.class);
                username = authenticationRequest.getUsername();
                password = authenticationRequest.getPassword();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication auth = authenticationManager.authenticate(authToken);
            return authenticationManager.authenticate(auth);
        }

        @Override
        protected void successfulAuthentication (HttpServletRequest request, HttpServletResponse response, FilterChain
        chain, Authentication authResult) throws IOException, ServletException {
            implementBean(request);
            String token = jwtService.generateAccessToken(request, (EmployeeDetails) authResult.getPrincipal());
            EmployeeResponse employeeResponse = new EmployeeResponse();
            BeanUtils.copyProperties(authResult.getPrincipal(), employeeResponse);
            AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
            Employees employee = employeeService.findByUsername(jwtService.getUsernameFromToke(token)).get();
            BeanUtils.copyProperties(employee, employeeResponse);
            AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                    .token(token)
                    .employeeResponse(employeeResponse)
                    .typeOfToken("Bearer")
                    .build();
            ApiResponseDto apiResponseDto = ApiResponseDto.builder().code(CommonConstants.MessageSuccess.SC007)
                    .message(null).data(authenticationResponse)
                    .message(messageUtils.getMessage(CommonConstants.MessageSuccess.SC007, null)).data(authenticationResponse)
                    .message(null).data(authenticationResponse)
                    .status(CommonConstants.ApiStatus.STATUS_OK).build();
            try {
                response.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
                response.setContentType("application/json");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


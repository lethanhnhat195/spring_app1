package com.ijv.internjava.sercurity.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.utils.CommonConstants;
<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
=======
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
>>>>>>> a3e137a (create update employee and change password)
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtEntrypoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a3e137a (create update employee and change password)
        String message = "";
        if(authException instanceof BadCredentialsException){
            message = "Username or password incorrect";
        }else {
            message = "Insufficient authority";
        }
<<<<<<< HEAD
=======
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
>>>>>>> a3e137a (create update employee and change password)
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseDto apiResponseDto = ApiResponseDto.builder()
<<<<<<< HEAD
<<<<<<< HEAD
                .message(message)
=======
                .code("123")
                .message("Username or password incorrect")
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
                .message(message)
>>>>>>> a3e137a (create update employee and change password)
                .data(null)
                .status(CommonConstants.ApiStatus.STATUS_ERROR)
                .build();
        response.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
    }
}

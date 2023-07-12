package com.ijv.internjava.sercurity.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.utils.CommonConstants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtEntrypoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseDto apiResponseDto = ApiResponseDto.builder()
                .code("123")
                .message("Username or password incorrect")
                .data(null)
                .status(CommonConstants.ApiStatus.STATUS_ERROR)
                .build();
        response.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
    }
}

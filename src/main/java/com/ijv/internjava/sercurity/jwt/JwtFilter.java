package com.ijv.internjava.sercurity.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.utils.CommonConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailService;

    @Override
    protected void doFilterInternal(
             HttpServletRequest request,
             HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        String username = null;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        try {
            username = jwtService.getUsernameFromToke(jwt);
        } catch (Exception e) {
            response.setStatus(400);
            response.setContentType("application/json");
            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponseDto apiResponseDto = ApiResponseDto.builder()
                    .message("Token no valid")
                    .status(CommonConstants.ApiStatus.STATUS_ERROR)
                    .build();
            response.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
        }
            UserDetails userDetails = userDetailService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null,
                    userDetails.getAuthorities()
            );
            authenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
    }
}

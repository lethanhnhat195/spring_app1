package com.ijv.internjava.sercurity.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.utils.CommonConstants;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import io.jsonwebtoken.JwtException;
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
>>>>>>> a3e137a (create update employee and change password)
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import jakarta.validation.constraints.NotNull;
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
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

<<<<<<< HEAD
    @Override
    protected void doFilterInternal(
             HttpServletRequest request,
             HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
=======

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException {
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        String username = null;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        try {
<<<<<<< HEAD
<<<<<<< HEAD
            username = jwtService.getUsernameFromToke(jwt);
        } catch (Exception e) {
=======
            username = jwtService.extractUsername(jwt);
        } catch (JwtException e) {
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
            username = jwtService.getUsernameFromToke(jwt);
        } catch (Exception e) {
>>>>>>> a3e137a (create update employee and change password)
            response.setStatus(400);
            response.setContentType("application/json");
            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponseDto apiResponseDto = ApiResponseDto.builder()
<<<<<<< HEAD
<<<<<<< HEAD
                    .message("Token no valid")
=======
                    .code("123")
                    .message("Token no valid")
                    .data(null)
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
                    .message("Token no valid")
>>>>>>> a3e137a (create update employee and change password)
                    .status(CommonConstants.ApiStatus.STATUS_ERROR)
                    .build();
            response.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
        }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 6c35d5d (Fix conflict in branch customer manager)
=======
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
=======
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
<<<<<<< HEAD
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
>>>>>>> b3c47dc (update dependency maven)
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
=======
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
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
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
    }
}

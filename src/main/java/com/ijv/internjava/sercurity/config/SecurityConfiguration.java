package com.ijv.internjava.sercurity.config;

import com.ijv.internjava.sercurity.jwt.JwtFilter;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
=======
import org.springframework.http.HttpStatus;
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
<<<<<<< HEAD
=======
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.io.IOException;
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
=======
import java.io.IOException;
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;
    private final JwtFilter jwtFilter;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private final String[] PUBLIC_URL = {"/login","/api/auth/**"};
=======
    private final JwtEntrypoint jwtEntrypoint;
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
    private final String[] PUBLIC_URL = {"/login","/api/auth/**"};
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
    private final String[] PUBLIC_URL = {"/login","/api/auth/**"};
=======
    private final JwtEntrypoint jwtEntrypoint;
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors().configurationSource(corsConfigurationSource()).and()
                .authorizeHttpRequests(auth -> auth
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
                        .requestMatchers(PUBLIC_URL).permitAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .apply(customDsl()).and()
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/abc/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtEntrypoint))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
                .logout().logoutSuccessHandler((request, response, authentication) ->
                        response.setStatus(HttpStatus.OK.value()))
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).clearAuthentication(true).
                and()
                .build();
    }

<<<<<<< HEAD
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
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        List<String> allowOrigins = configuration.getAllowedOrigins();
        configuration.setAllowedOriginPatterns(allowOrigins);
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
    public MyCustomDsl customDsl() {
        return new MyCustomDsl();
    }
  public  class MyCustomDsl extends  AbstractHttpConfigurer<MyCustomDsl , HttpSecurity>{
        @Override
      public void configure(HttpSecurity httpSecurity) throws Exception{
            AuthenticationManager authenticationManager = httpSecurity.getSharedObject(AuthenticationManager.class);
            httpSecurity.addFilter(new CustomAuthenticationFilter(authenticationManager))
                    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
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
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)

}

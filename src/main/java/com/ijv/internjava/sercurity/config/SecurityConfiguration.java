package com.ijv.internjava.sercurity.config;

import com.ijv.internjava.sercurity.jwt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;
    private final JwtFilter jwtFilter;
    private final String[] PUBLIC_URL = {"/login","/api/auth/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors().configurationSource(corsConfigurationSource()).and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PUBLIC_URL).permitAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .apply(customDsl()).and()
                .logout().logoutSuccessHandler((request, response, authentication) ->
                        response.setStatus(HttpStatus.OK.value()))
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).clearAuthentication(true).
                and()
                .build();
    }


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

}

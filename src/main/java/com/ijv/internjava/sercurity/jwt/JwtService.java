package com.ijv.internjava.sercurity.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;

import com.ijv.internjava.utils.CommonConstants;
<<<<<<< HEAD
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import io.jsonwebtoken.security.Keys;
=======
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final String SECRET_KEY = "key_secret";

    public String getUsernameFromToke(String jwt){
        DecodedJWT decodedJWT = JWT.decode(jwt);
        decodedJWT.getPayload();
        return decodedJWT.getSubject();
    }
    public String generateAccessToken(HttpServletRequest request,EmployeeDetails employeeDetails) {
        List<String> roles = employeeDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + (60 * 60 * 24 * 1000L)))
                .withSubject(employeeDetails.getUsername())
                .withIssuer(request.getRequestURI())
                .withClaim(CommonConstants.Authentication.ROLES,roles)
                .sign(algorithm);
    }
}

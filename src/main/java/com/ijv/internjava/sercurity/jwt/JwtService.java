package com.ijv.internjava.sercurity.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
<<<<<<< HEAD
<<<<<<< HEAD
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;

import com.ijv.internjava.utils.CommonConstants;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 81be34c (Fix conflict on branch customer manager)
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import io.jsonwebtoken.security.Keys;
=======
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
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import io.jsonwebtoken.security.Keys;
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> a3e137a (create update employee and change password)
>>>>>>> 81be34c (Fix conflict on branch customer manager)
=======
>>>>>>> b3c47dc (update dependency maven)
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
=======
=======
import com.auth0.jwt.interfaces.DecodedJWT;
>>>>>>> a3e137a (create update employee and change password)
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;

import com.ijv.internjava.utils.CommonConstants;
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
<<<<<<< HEAD

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(EmployeeDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private String generateToken(Map<String, Object> extraClaims, EmployeeDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 64 * 24))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
//    public String generateAccessToken(HttpServletRequest,EmployeeDetails employeeDetails) {
//        List<String> roles = employeeDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
//        return JWT.create()
//                .withExpiresAt(new Date(System.currentTimeMillis() + (60 * 60 * 24 * 1000L)))
//                .sign(algorithm);
//    }
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
>>>>>>> a3e137a (create update employee and change password)
}

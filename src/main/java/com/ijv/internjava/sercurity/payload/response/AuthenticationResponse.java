package com.ijv.internjava.sercurity.payload.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private EmployeeResponse employeeResponse;
    private String typeOfToken;
}

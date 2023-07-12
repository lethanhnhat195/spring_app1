package com.ijv.internjava.sercurity.payload.response;

import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private EmployeeResponse employeeResponse;
}

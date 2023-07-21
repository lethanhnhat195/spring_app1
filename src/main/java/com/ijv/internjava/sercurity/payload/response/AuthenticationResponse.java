package com.ijv.internjava.sercurity.payload.response;

<<<<<<< HEAD
=======
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private EmployeeResponse employeeResponse;
<<<<<<< HEAD
    private String typeOfToken;
=======
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
}

package com.ijv.internjava.sercurity.payload.response;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
>>>>>>> a3e137a (create update employee and change password)
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private EmployeeResponse employeeResponse;
<<<<<<< HEAD
<<<<<<< HEAD
    private String typeOfToken;
=======
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
    private String typeOfToken;
>>>>>>> a3e137a (create update employee and change password)
}

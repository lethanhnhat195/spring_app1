package com.ijv.internjava.sercurity.payload.request;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Data
public class PasswordUpdateRequest implements Validator {
<<<<<<< HEAD
=======
    private String username;
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
    private String newPassword;
    private String confirmPassword;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordUpdateRequest request = (PasswordUpdateRequest) target;
        if(request.getNewPassword().equals(confirmPassword))
        {
            errors.rejectValue("password","password and confirm password not match");
        }
    }
}

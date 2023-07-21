package com.ijv.internjava.sercurity.payload.request;


import com.ijv.internjava.model.entity.WorkShift;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Data
public class EmployeeUpdateRequest implements Validator {
    private Long id;
    private String name;
    private Boolean gender;
    private Date birthday;
    @Pattern(regexp = "\\d{10,12}",message = "Phone number must have 10 - 12 number")
    private String phone;
    private String address;
    @Pattern(regexp = "[\\w]+[@][\\w]+.[\\w]+", message = "Email no valid")
    private String email;
    @NotBlank
    private String image;
    private WorkShift workShift;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

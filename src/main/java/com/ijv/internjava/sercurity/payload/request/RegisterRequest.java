package com.ijv.internjava.sercurity.payload.request;

import com.ijv.internjava.model.entity.WorkShift;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "not blank")
    private String username;
    @NotBlank(message = "not blank")
    private String password;
    @NotBlank(message = "not blank")
    private String confirmPassword;
    @NotBlank(message = "not blank")
    private String name;
    private Boolean gender;
    private Date birthday;
    @NotBlank(message = "not blank")
    private String phone;
    private String address;
    @NotBlank(message = "not blank")

    private String email;
    private String image;
    private Set<String> roles;
    private WorkShift workShift;

}

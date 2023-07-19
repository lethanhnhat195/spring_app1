package com.ijv.internjava.sercurity.payload.response;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.List;

@Data
public class EmployeeResponse {
    private String name;
    private Boolean gender;
    private Date birthday;
    private String phone;
    private String address;
    private String email;
    private String image;
    private List<GrantedAuthority> roles;
}

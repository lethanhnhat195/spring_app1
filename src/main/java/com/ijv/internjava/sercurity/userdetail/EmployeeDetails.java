package com.ijv.internjava.sercurity.userdetail;

import com.ijv.internjava.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
@Transactional
@NoArgsConstructor
public class EmployeeDetails implements UserDetails {
    private String username;
    private String password;
    private Long id;
    private String name;
    private Boolean gender;
    private Date birthday;
    private String phone;
    private String address;
    private String email;
    private String image;
    private List<GrantedAuthority> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public static EmployeeDetails build(Employee employee) {
        List<GrantedAuthority> authorities = employee.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        EmployeeDetails employeeDetails = new EmployeeDetails();
        BeanUtils.copyProperties(employee,employeeDetails);
        employeeDetails.setRoles(authorities);
        return employeeDetails;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

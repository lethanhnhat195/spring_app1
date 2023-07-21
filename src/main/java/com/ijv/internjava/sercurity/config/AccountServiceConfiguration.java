package com.ijv.internjava.sercurity.config;

<<<<<<< HEAD
<<<<<<< HEAD
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;
import com.ijv.internjava.service.EmployeeService;
=======
import com.ijv.internjava.repository.IEmployeeRepository;
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;
import com.ijv.internjava.service.IEmployeeService;
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
import com.ijv.internjava.sercurity.userdetail.EmployeeDetails;
import com.ijv.internjava.service.EmployeeService;
>>>>>>> 56d4993 (fix conflict from main branch)
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AccountServiceConfiguration {

    @Autowired
<<<<<<< HEAD
<<<<<<< HEAD
    private EmployeeService employeeService;
=======
    private IEmployeeService employeeService;
>>>>>>> d395b7d (create config sercurity and jwt to sign-in and sign-up)
=======
    private EmployeeService employeeService;
>>>>>>> 56d4993 (fix conflict from main branch)

    @Bean
    public UserDetailsService loadUserByUsername() {
        return username -> EmployeeDetails.build(employeeService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found")));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(loadUserByUsername());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

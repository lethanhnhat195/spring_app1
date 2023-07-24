package com.ijv.internjava.repository;

import com.ijv.internjava.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %?1% " +
            "OR e.email LIKE %?1%" +
            "OR e.phone LIKE %?1%")
    List<Employees> searchEmployees(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %?1%")
    Optional<Employees> findEmployeeByEmail(String email);

    Optional<Employees> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByPhone(String phone);
}

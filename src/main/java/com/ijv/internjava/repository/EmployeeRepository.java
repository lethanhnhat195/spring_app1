package com.ijv.internjava.repository;

import com.ijv.internjava.model.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.transaction.annotation.Transactional;
=======
>>>>>>> fb13f8d (create repository, service and controller for employee management)
=======
import org.springframework.transaction.annotation.Transactional;
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333

import java.util.List;
import java.util.Optional;

@Repository
<<<<<<< HEAD
<<<<<<< HEAD
@Transactional
=======
>>>>>>> fb13f8d (create repository, service and controller for employee management)
=======
@Transactional
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %?1% " +
            "OR e.email LIKE %?1%" +
            "OR e.phone LIKE %?1%")
    List<Employee> searchEmployees(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %?1%")
    Optional<Employee> findEmployeeByEmail(String email);

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
    Optional<Employee> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByPhone(String phone);
<<<<<<< HEAD
=======

>>>>>>> fb13f8d (create repository, service and controller for employee management)
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333

}

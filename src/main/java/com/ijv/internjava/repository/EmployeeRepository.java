package com.ijv.internjava.repository;

import com.ijv.internjava.model.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> fe4beda (Fix conflict in branch customer manager)
=======
>>>>>>> 05f926d (Fix conflict on branch customer manager)
import org.springframework.transaction.annotation.Transactional;
=======
>>>>>>> fb13f8d (create repository, service and controller for employee management)
=======
<<<<<<< HEAD
import org.springframework.transaction.annotation.Transactional;
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
import org.springframework.transaction.annotation.Transactional;
=======
>>>>>>> fb13f8d (create repository, service and controller for employee management)
>>>>>>> b3c47dc (update dependency maven)
=======
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
<<<<<<< HEAD
>>>>>>> fe4beda (Fix conflict in branch customer manager)
=======
=======
import org.springframework.transaction.annotation.Transactional;
>>>>>>> 56d4993 (fix conflict from main branch)
>>>>>>> 05f926d (Fix conflict on branch customer manager)

import java.util.List;
import java.util.Optional;

@Repository
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> fe4beda (Fix conflict in branch customer manager)
=======
>>>>>>> 05f926d (Fix conflict on branch customer manager)
@Transactional
=======
>>>>>>> fb13f8d (create repository, service and controller for employee management)
=======
<<<<<<< HEAD
@Transactional
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
@Transactional
=======
>>>>>>> fb13f8d (create repository, service and controller for employee management)
>>>>>>> b3c47dc (update dependency maven)
=======
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
<<<<<<< HEAD
>>>>>>> fe4beda (Fix conflict in branch customer manager)
=======
=======
@Transactional
>>>>>>> 56d4993 (fix conflict from main branch)
>>>>>>> 05f926d (Fix conflict on branch customer manager)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %?1% " +
            "OR e.email LIKE %?1%" +
            "OR e.phone LIKE %?1%")
    List<Employee> searchEmployees(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %?1%")
    Optional<Employee> findEmployeeByEmail(String email);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
>>>>>>> b3c47dc (update dependency maven)
=======
>>>>>>> fe4beda (Fix conflict in branch customer manager)
=======
=======
>>>>>>> 56d4993 (fix conflict from main branch)
>>>>>>> 05f926d (Fix conflict on branch customer manager)
    Optional<Employee> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByPhone(String phone);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 05f926d (Fix conflict on branch customer manager)
=======

>>>>>>> fb13f8d (create repository, service and controller for employee management)
=======
<<<<<<< HEAD
>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
=======
=======

>>>>>>> fb13f8d (create repository, service and controller for employee management)
>>>>>>> b3c47dc (update dependency maven)
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
<<<<<<< HEAD
>>>>>>> fe4beda (Fix conflict in branch customer manager)
=======
=======
>>>>>>> 56d4993 (fix conflict from main branch)
>>>>>>> 05f926d (Fix conflict on branch customer manager)

}

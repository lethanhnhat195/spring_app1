package com.ijv.internjava.repository;

import com.ijv.internjava.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, JpaSpecificationExecutor<Booking> {
    @Query("SELECT p FROM Booking p WHERE CONCAT(p.customer, p.phoneNumber, p.bookingDate, p.fromTime, p.toTime) LIKE %?1%")
    public List<Booking> search(String keyword);
}

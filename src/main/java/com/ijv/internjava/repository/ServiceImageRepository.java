package com.ijv.internjava.repository;

import com.ijv.internjava.model.entity.ServicesImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceImageRepository extends JpaRepository<ServicesImage, Long> {
}

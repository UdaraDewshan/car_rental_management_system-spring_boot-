package edu.icet.repository;

import edu.icet.model.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,String> {
    List<Driver> findByStatesTrue();
}
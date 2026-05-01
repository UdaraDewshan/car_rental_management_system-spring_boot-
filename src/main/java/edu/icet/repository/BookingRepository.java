package edu.icet.repository;

import edu.icet.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    @Query("SELECT COUNT(b) FROM Booking b WHERE b.carId.carId = :carId AND b.status IN ('PENDING', 'APPROVED') AND (b.startDate <= :endDate AND b.endDate >= :startDate)")
    int countOverlappingBookings(@Param("carId") String carId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Booking> findByUserId(edu.icet.model.entity.User user);
}
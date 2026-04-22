package edu.icet.service;

import edu.icet.model.dto.BookingDTO;
import edu.icet.model.entity.Booking;
import edu.icet.model.entity.Car;
import edu.icet.model.entity.User;
import edu.icet.repository.BookingRepository;
import edu.icet.repository.CarRepository;
import edu.icet.repository.DriverRepository;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;

    public String addBooking(BookingDTO dto) {

        int overlappingCount = bookingRepository.countOverlappingBookings(dto.getCarId(), dto.getStartDate(), dto.getEndDate());

        if (overlappingCount > 0) {
            throw new RuntimeException("Sorry! This vehicle is already booked for the selected dates.");
        }

        Booking booking = new Booking();
        booking.setBookingId("B-" + UUID.randomUUID().toString().substring(0, 6));

        Car car = carRepository.findById(dto.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
        booking.setCarId(car);

        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(currentUserEmail).orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUserId(user);

        booking.setStartDate(dto.getStartDate());
        booking.setEndDate(dto.getEndDate());
        booking.setWithDriver(dto.isWithDriver());
        booking.setTotalPrice(dto.getTotalPrice());

        bookingRepository.save(booking);
        return "Booking Successful!";
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public String updateBookingStatud(String bookingId, String status, String driverId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(status);

        if (driverId != null && !driverId.isEmpty()) {
            edu.icet.model.entity.Driver driver = driverRepository.findById(driverId)
                    .orElseThrow(() -> new RuntimeException("Driver not found"));
            booking.setDriverId(driver);

            driver.setStates(false);
            driverRepository.save(driver);
        }

        bookingRepository.save(booking);
        return "Booking status updated successfully!";
    }

    public List<Booking> getMyBookings() {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingRepository.findByUserId(user);
    }
}
package edu.icet.service;

import edu.icet.model.dto.BookingDTO;
import edu.icet.model.entity.Booking;
import edu.icet.model.entity.Car;
import edu.icet.model.entity.User;
import edu.icet.repository.BookingRepository;
import edu.icet.repository.CarRepository;
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

    public String addBooking(BookingDTO dto) {
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

    public @Nullable String updateBookingStatud(String bookingId, String status) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(status);
        bookingRepository.save(booking);
        return "Booking status updated successfully!"+status;
    }
}
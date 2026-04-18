package edu.icet.service;

import edu.icet.model.dto.BookingDTO;
import edu.icet.model.entity.Booking;
import edu.icet.model.entity.Car;
import edu.icet.model.entity.User;
import edu.icet.repository.BookingRepository;
import edu.icet.repository.CarRepository;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUserId(user);

        booking.setStartDate(dto.getStartDate());
        booking.setEndDate(dto.getEndDate());
        booking.setWithDriver(dto.isWithDriver());
        booking.setTotalPrice(dto.getTotalPrice());

        bookingRepository.save(booking);

        return "Booking Successful!";
    }
}
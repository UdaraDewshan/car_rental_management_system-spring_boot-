package edu.icet.controller;

import edu.icet.model.dto.BookingDTO;
import edu.icet.model.entity.Booking;
import edu.icet.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<String> addBooking(@RequestBody BookingDTO bookingDTO) {
        try {
            return ResponseEntity.ok(bookingService.addBooking(bookingDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @PutMapping("/updateStatus/{bookingId}")
    public ResponseEntity<String> updateStatus(@PathVariable String bookingId, @RequestParam String status) {
        return ResponseEntity.ok(bookingService.updateBookingStatus(bookingId, status));
    }

    @GetMapping("/my-bookings")
    public ResponseEntity<List<Booking>> getMyBookings() {
        return ResponseEntity.ok(bookingService.getMyBookings());
    }
}
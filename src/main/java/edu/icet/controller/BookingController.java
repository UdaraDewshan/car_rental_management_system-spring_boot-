package edu.icet.controller;

import edu.icet.model.dto.BookingDTO;
import edu.icet.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<String> addBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.addBooking(bookingDTO));
    }
}
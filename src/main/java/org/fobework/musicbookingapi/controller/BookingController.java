package org.fobework.musicbookingapi.controller;
import org.fobework.musicbookingapi.dto.BookingDto;
import org.fobework.musicbookingapi.dto.CreateBookingDto;
import org.fobework.musicbookingapi.services.implementation.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDto> getBookings() {
        return bookingService.getAllBookings();
    }

    // For booking creation, we pass an eventId as a request parameter
    @PostMapping
    public BookingDto createBooking(@RequestParam Long eventId, @RequestBody CreateBookingDto booking) {
        return bookingService.createBooking(booking, eventId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}

package org.fobework.musicbookingapi.services.implementation;

import org.fobework.musicbookingapi.data.Repo.BookingRepository;
import org.fobework.musicbookingapi.data.Repo.EventRepository;
import org.fobework.musicbookingapi.data.model.Event;
import org.fobework.musicbookingapi.dto.BookingDto;
import org.fobework.musicbookingapi.dto.CreateBookingDto;
import org.fobework.musicbookingapi.util.AutoMapper;
import org.springframework.stereotype.Service;
import org.fobework.musicbookingapi.data.model.Booking;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;

    public BookingService(BookingRepository bookingRepository, EventRepository eventRepository) {
        this.bookingRepository = bookingRepository;
        this.eventRepository = eventRepository;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingDto> bookingDtos = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDto bookingDto = new BookingDto();
            AutoMapper.mapper(booking,bookingDto);
            bookingDtos.add(bookingDto);
        }
        return bookingDtos;
    }

    public BookingDto createBooking(CreateBookingDto booking, Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        Booking booking1 = new Booking();
        booking1.setEvent(event);
        AutoMapper.mapper(booking,booking1);
        BookingDto bookingDto = new BookingDto();
        AutoMapper.mapper(booking1,bookingDto);
        return bookingDto;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}

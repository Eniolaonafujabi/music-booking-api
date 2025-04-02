package org.fobework.musicbookingapi.util;

import org.fobework.musicbookingapi.data.model.Artist;
import org.fobework.musicbookingapi.data.model.Booking;
import org.fobework.musicbookingapi.dto.ArtistDto;
import org.fobework.musicbookingapi.dto.BookingDto;
import org.fobework.musicbookingapi.dto.CreateArtistDto;
import org.fobework.musicbookingapi.dto.CreateBookingDto;

public class AutoMapper {
    public static void mapper(Artist artist, CreateArtistDto createArtistDto) {
        artist.setName(createArtistDto.getName());
        artist.setGenre(createArtistDto.getGenre());
        artist.setBio(createArtistDto.getBio());
    }

    public static void mapper(Artist artist, ArtistDto artistDto) {
        artistDto.setId(artist.getId());
        artistDto.setName(artist.getName());
        artistDto.setGenre(artist.getGenre());
        artistDto.setBio(artist.getBio());
    }

    public static void mapper(Booking booking, BookingDto bookingDto) {
        bookingDto.setId(booking.getId());
        bookingDto.setBookingTime(booking.getBookingTime());
        bookingDto.setEvent(booking.getEvent());
        bookingDto.setCustomerName(booking.getCustomerName());
    }

    public static void mapper(CreateBookingDto booking, Booking booking1) {
        booking1.setBookingTime(booking.getBookingTime());
        booking1.setCustomerName(booking.getCustomerName());
    }
}

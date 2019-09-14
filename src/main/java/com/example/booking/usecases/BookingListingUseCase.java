package com.example.booking.usecases;

import com.example.booking.entities.Booking;
import com.example.booking.repository.BookingOperations;

import java.time.LocalDate;
import java.util.List;

public class BookingListingUseCase {
    private BookingOperations bookingOperations;

    public BookingListingUseCase(BookingOperations bookingOperations) {
        this.bookingOperations = bookingOperations;
    }

    public List<Booking> list(LocalDate date) {
        return this.bookingOperations.listBookings(date);
    }
}

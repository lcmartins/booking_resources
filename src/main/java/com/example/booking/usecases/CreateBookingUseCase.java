package com.example.booking.usecases;

import com.example.booking.entities.Booking;
import com.example.booking.repository.BookingOperations;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.List;

public class CreateBookingUseCase {
    private BookingOperations bookingOperations;

    public CreateBookingUseCase(BookingOperations bookingOperations) {
        this.bookingOperations = bookingOperations;
    }

    public Integer createNew(Booking newBooking) {
        List<Booking> bookings = this.bookingOperations.listBookings(newBooking.getBegin().toLocalDate());
        for (Booking bookingExistente : bookings) {
            if(isInvalidRange(newBooking) || hasBookingCrash(newBooking.getBegin(), newBooking.getEnd(), bookingExistente)) {
                throw new InvalidParameterException("Wrong parameters or booking range clash");
            }
        }
        return this.bookingOperations.createAndReturnId(newBooking);
    }

    private boolean isInvalidRange(Booking newBooking) {
        return newBooking.getBegin().compareTo(newBooking.getEnd()) >= 0;
    }
    private boolean isRequstEndingGreaterThanBeginAndLessEqualEnding(LocalDateTime end, Booking booking) {
        return end.compareTo(booking.getBegin()) > 0 && end.compareTo(booking.getEnd()) <= 0;
    }

    private boolean isRequestBeginGreaterThanBeginButLessEqualEnding(LocalDateTime begin, Booking booking) {
        return begin.compareTo(booking.getBegin()) > 0 && begin.compareTo(booking.getEnd()) <= 0;
    }
    private boolean isRequestInRange(LocalDateTime begin, LocalDateTime end, Booking booking) {
        return begin.compareTo(booking.getBegin()) >= 0 && end.compareTo(booking.getEnd()) <= 0;
    }

    private boolean requestContainsExistingBookingRange(LocalDateTime begin, LocalDateTime end, Booking booking) {
        return begin.compareTo(booking.getBegin()) < 0 && end.compareTo(booking.getEnd()) > 0;
    }

    private boolean hasBookingCrash(LocalDateTime begin, LocalDateTime end, Booking booking) {
            return isRequstEndingGreaterThanBeginAndLessEqualEnding(end, booking)
                || isRequestBeginGreaterThanBeginButLessEqualEnding(begin, booking)
                || isRequestInRange(begin, end, booking)
                || requestContainsExistingBookingRange(begin, end, booking);
    }
}

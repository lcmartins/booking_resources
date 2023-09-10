package com.example.booking.usecases;

import com.example.booking.entities.Booking;
import com.example.booking.repository.BookingOperations;

import java.security.InvalidParameterException;
import java.util.List;

public class CreateBookingUseCase {
    private BookingOperations bookingOperations;

    public CreateBookingUseCase(BookingOperations bookingOperations) {
        this.bookingOperations = bookingOperations;
    }

    public Integer createNew(Booking newBooking) {
        List<Booking> bookings = this.bookingOperations.listBookings(newBooking.getBeginning().toLocalDate());
        for (Booking bookingExistente : bookings) {
            if(newBooking.isInvalidRange() || hasBookingCrash(newBooking, bookingExistente)) {
                throw new InvalidParameterException("Wrong parameters or booking range clash");
            }
        }
        return this.bookingOperations.createAndReturnId(newBooking);
    }

    private boolean hasBookingCrash(Booking requestBooking, Booking existingBooking) {
        return requestBooking.isRequestEndingCrashingInMidleOfExisting(existingBooking)
                || requestBooking.isRequestBeginningCrashingInMidleOfExisting(existingBooking)
                || requestBooking.isRequestInSameRangeOfExistingBooking(existingBooking)
                || requestBooking.requestRangeContainsExistingBookingRange(existingBooking);
    }
}

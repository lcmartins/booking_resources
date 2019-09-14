package com.example.booking.repository;

import com.example.booking.entities.Booking;
import com.example.booking.entities.Resource;
import com.example.booking.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface BookingOperations {
    List<Resource> listResources();
    List<User> listUsers();
    List<Booking> listBookings(LocalDate bookingDate);
    Integer createAndReturnId(Booking booking);
}

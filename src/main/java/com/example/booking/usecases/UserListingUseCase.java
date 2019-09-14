package com.example.booking.usecases;

import com.example.booking.entities.User;
import com.example.booking.repository.BookingOperations;

import java.util.List;

public class UserListingUseCase {

    private BookingOperations bookingOperations;

    public UserListingUseCase(BookingOperations bookingOperations) {
        this.bookingOperations = bookingOperations;
    }

    public List<User> list() {
        return  this.bookingOperations.listUsers();
    }

}

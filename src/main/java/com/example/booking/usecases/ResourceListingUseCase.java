package com.example.booking.usecases;

import com.example.booking.entities.Resource;
import com.example.booking.repository.BookingOperations;

import java.util.List;

public class ResourceListingUseCase {
    private BookingOperations bookingOperationsRepository;

    public ResourceListingUseCase(BookingOperations bookingOperationsRepository) {
        this.bookingOperationsRepository = bookingOperationsRepository;
    }

    public List<Resource> list() {
        return this.bookingOperationsRepository.listResources();
    }
}

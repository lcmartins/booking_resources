package com.example.booking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.booking.repository.BookingRepository;
import com.example.booking.repository.BookingOperations;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public BookingOperations createBookingRepository() {
        return new BookingRepository();
    }
}

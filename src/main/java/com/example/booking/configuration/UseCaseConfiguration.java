package com.example.booking.configuration;

import com.example.booking.repository.BookingRepository;
import com.example.booking.usecases.CreateBookingUseCase;
import com.example.booking.usecases.BookingListingUseCase;
import com.example.booking.usecases.ResourceListingUseCase;
import com.example.booking.usecases.UserListingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public ResourceListingUseCase creeateResourceListUseCase(final BookingRepository bookingRepository) {
        return new ResourceListingUseCase(bookingRepository);
    }

    @Bean
    public UserListingUseCase createUserListingUseCase(final BookingRepository bookingRepository) {
        return new UserListingUseCase(bookingRepository);
    }

    @Bean
    public CreateBookingUseCase createCreateBookingUseCase(final BookingRepository bookingRepository) {
        return new CreateBookingUseCase(bookingRepository);
    }

    @Bean
    public BookingListingUseCase createBookingListUseCase(final BookingRepository bookingRepository) {
        return new BookingListingUseCase(bookingRepository);
    }
}

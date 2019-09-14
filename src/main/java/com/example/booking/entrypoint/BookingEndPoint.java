package com.example.booking.entrypoint;

import com.example.booking.entities.Booking;
import com.example.booking.entrypoint.request.BookingRequest;
import com.example.booking.usecases.BookingListingUseCase;
import com.example.booking.usecases.CreateBookingUseCase;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingEndPoint {
    private CreateBookingUseCase createBookingUseCase;
    private BookingListingUseCase bookingListingUseCase;

    public BookingEndPoint(CreateBookingUseCase createBookingUseCase, BookingListingUseCase bookingListingUseCase) {
        this.createBookingUseCase = createBookingUseCase;
        this.bookingListingUseCase = bookingListingUseCase;
    }

    @PostMapping
    public Integer create(@RequestBody BookingRequest request){
        return this.createBookingUseCase.createNew(request.toEntity());
    }

    @GetMapping
    public List<Booking> listByDate(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return this.bookingListingUseCase.list(data);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        System.out.println(e);
    }

}

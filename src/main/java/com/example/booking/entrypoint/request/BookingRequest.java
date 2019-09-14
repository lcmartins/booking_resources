package com.example.booking.entrypoint.request;

import com.example.booking.entities.Booking;
import com.example.booking.entities.Resource;
import com.example.booking.entities.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class BookingRequest {
    private Resource resource;
    private User user;
    private Long beginMiliseconds;
    private Long endMiliseconds;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getBeginMiliseconds() {
        return beginMiliseconds;
    }

    public void setBeginMiliseconds(Long beginMiliseconds) {
        this.beginMiliseconds = beginMiliseconds;
    }

    public Long getEndMiliseconds() {
        return endMiliseconds;
    }

    public void setEndMiliseconds(Long endMiliseconds) {
        this.endMiliseconds = endMiliseconds;
    }

    public BookingRequest(Resource resource, User user, Long beginMiliseconds, Long endMiliseconds) {
        this.resource = resource;
        this.user = user;
        this.beginMiliseconds = beginMiliseconds;
        this.endMiliseconds = endMiliseconds;
    }

    public  BookingRequest() {
        super();
    }

    public Booking toEntity() {
        LocalDateTime beginFromLong = Instant.ofEpochMilli(this.beginMiliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime endFromLong = Instant.ofEpochMilli(this.endMiliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return  new Booking(this.resource, this.user, beginFromLong, endFromLong);
    }
}

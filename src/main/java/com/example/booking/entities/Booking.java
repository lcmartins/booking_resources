package com.example.booking.entities;

import java.time.LocalDateTime;

public class Booking {
    private int id;
    private Resource resource;
    private User user;
    private LocalDateTime begining;
    private LocalDateTime ending;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Resource getRecurso() {
        return resource;
    }

    public void setRecurso(Resource resource) {
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getBeginning() {
        return begining;
    }

    public void setBegining(LocalDateTime begining) {
        this.begining = begining;
    }

    public LocalDateTime getEnding() {
        return ending;
    }

    public void setEnding(LocalDateTime ending) {
        this.ending = ending;
    }

    public Booking(int id, Resource resource, User user, LocalDateTime begining, LocalDateTime ending) {
        this.id = id;
        this.resource = resource;
        this.user = user;
        this.begining = begining;
        this.ending = ending;
    }

    public Booking(Resource resource, User user, LocalDateTime begining, LocalDateTime ending) {
        this.resource = resource;
        this.user = user;
        this.begining = begining;
        this.ending = ending;
    }

    public boolean isInvalidRange() {
        return !this.getBeginning().isBefore(this.getEnding());
    }

    public boolean isRequestEndingCrashingInMidleOfExisting(Booking existingBooking) {
        return this.getEnding().isAfter(existingBooking.getBeginning()) && !this.getEnding().isAfter(existingBooking.getEnding());
    }


    public boolean isRequestBeginningCrashingInMidleOfExisting(Booking existingBooking) {
        return this.getBeginning().isAfter(existingBooking.getBeginning()) && !this.getBeginning().isAfter(existingBooking.getEnding());
    }

    public boolean isRequestInSameRangeOfExistingBooking(Booking booking) {
        return !this.getBeginning().isBefore(booking.getBeginning()) && !this.getEnding().isAfter(booking.getEnding());
    }

    public boolean requestRangeContainsExistingBookingRange(Booking booking) {
        return this.getBeginning().isBefore(booking.getBeginning()) && this.getEnding().isAfter(booking.getEnding());
    }
}

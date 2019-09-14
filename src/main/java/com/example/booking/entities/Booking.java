package com.example.booking.entities;

import java.time.LocalDateTime;

public class Booking {
    private int id;
    private Resource resource;
    private User user;
    private LocalDateTime begin;
    private LocalDateTime end;



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

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Booking(int id, Resource resource, User user, LocalDateTime begin, LocalDateTime end) {
        this.id = id;
        this.resource = resource;
        this.user = user;
        this.begin = begin;
        this.end = end;
    }

    public Booking(Resource resource, User user, LocalDateTime begin, LocalDateTime end) {
        this.resource = resource;
        this.user = user;
        this.begin = begin;
        this.end = end;
    }
}

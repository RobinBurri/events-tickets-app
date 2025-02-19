package com.tickets_online.tickets.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tickets_online.tickets.models.Organizer;

@Repository
public class OrganizerRepository {
    private final List<Organizer> organizers = List.of(
            new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
            new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment"));

    public List<Organizer> findAll() {
        return organizers;
    }
}

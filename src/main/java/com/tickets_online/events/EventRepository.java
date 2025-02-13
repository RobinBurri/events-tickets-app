package com.tickets_online.events;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class EventRepository {
    private final List<Event> events = List.of(
            new Event(501, "Globomantics", new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
                    new Venue(201, "Globomaics Main Office", "Test Street 325", "New Yourk", "USA"),
                    LocalDate.of(2025, 10, 2), LocalDate.of(2035, 10, 4)),
            new Event(502, "Globomatics  Developer Day",
                    new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
                    new Venue(201, "Globomaics Main Office", "Test Street 325", "New Yourk", "USA"),
                    LocalDate.of(2025, 1, 20), LocalDate.of(2035, 1, 20)),
            new Event(503, "Caved Rock", new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment"),
                    new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "USA"),
                    LocalDate.of(2025, 2, 23), LocalDate.of(2025, 2, 24)));

    public List<Event> findByOrganizerId(int organizerId) {
        return events.stream().filter(event -> event.organizer().id() == organizerId).toList();
    }

    public Optional<Event> findById(int id) {
        return events.stream().filter(event -> event.id() == id).findAny();
    }
}

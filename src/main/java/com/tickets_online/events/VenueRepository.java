package com.tickets_online.events;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class VenueRepository {

    private final List<Venue> venues = List.of(
        new Venue(201, "Globomaics Main Office", "Test Street 325", "New Yourk", "USA"),
        new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "USA")
    );

    public Optional<Venue> findById(int id) {
        return venues.stream().filter(venue -> venue.id() == id).findAny();
    }
}

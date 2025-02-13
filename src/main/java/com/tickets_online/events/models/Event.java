package com.tickets_online.events.models;

import java.time.LocalDate;

public record Event(int id, String name, Organizer organizer, Venue venue, LocalDate startDate, LocalDate endDate) {
    
}
